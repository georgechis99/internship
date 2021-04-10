package com.arobs.library.service;

import com.arobs.library.exception.EmployeeException;
import com.arobs.library.exception.InvalidInputException;
import com.arobs.library.exception.ResourceNotFoundException;
import com.arobs.library.model.dto.BookRentDTO;
import com.arobs.library.model.entity.Book;
import com.arobs.library.model.entity.BookRent;
import com.arobs.library.model.entity.Copy;
import com.arobs.library.model.entity.Employee;
import com.arobs.library.model.helper.BookRentStatus;
import com.arobs.library.model.helper.CopyState;
import com.arobs.library.model.helper.CopyStatus;
import com.arobs.library.model.mapper.BookRentMapper;
import com.arobs.library.model.repository.BookRentRepository;
import com.arobs.library.model.repository.BookRepository;
import com.arobs.library.model.repository.CopyRepository;
import com.arobs.library.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class BookRentService {

    private BookRentRepository bookRentRepository;
    private BookRepository bookRepository;
    private EmployeeRepository employeeRepository;
    private CopyRepository copyRepository;
    private BookRentMapper bookRentMapper;

    @Autowired
    public BookRentService(BookRentRepository bookRentRepository, BookRepository bookRepository,
                           EmployeeRepository employeeRepository, CopyRepository copyRepository, BookRentMapper bookRentMapper) {
        this.bookRentRepository = bookRentRepository;
        this.bookRepository = bookRepository;
        this.employeeRepository = employeeRepository;
        this.copyRepository = copyRepository;
        this.bookRentMapper = bookRentMapper;
    }

    @Transactional
    public List<BookRentDTO> findAll() {
        List<BookRent> bookRents = bookRentRepository.findAll();
        return toDTOList(bookRents);
    }

    @Transactional
    public BookRentDTO markAsLate(BookRentDTO bookRentDTO) {
        BookRent bookRent = bookRentMapper.toEntity(bookRentDTO);
        setEntityFields(bookRent, bookRentDTO);
        bookRent.setStatus(BookRentStatus.late);
        return bookRentMapper.toDTO(bookRentRepository.save(bookRent));
    }

    @Transactional
    public BookRentDTO rentBook(int employeeId, int bookId) {
        BookRent bookRent = new BookRent();
        Employee employee = validateEmployee(employeeId);
        bookRent.setEmployee(employee);

        Book book = validateBook(bookId);
        bookRent.setBook(book);

        Copy copy = getAvailableCopy(book);
        bookRent.setCopy(copy);

        Date currentDate = getCurrentDate();
        Date futureDate = datePlus30Days(currentDate);
        bookRent.setRentalDate(currentDate);
        bookRent.setReturnDate(futureDate);
        bookRent.setStatus(BookRentStatus.ongoing);

        copy.setStatus(CopyStatus.rented);
        return bookRentMapper.toDTO(bookRentRepository.save(bookRent));
    }

    @Transactional
    public BookRentDTO returnBook(int bookRentId, Integer rating, String noteAtReturn) {
        BookRent bookRent = validateBookRentForReturn(bookRentId);

        Copy copy = bookRent.getCopy();
        copy.setStatus(CopyStatus.available);

        Date returnDate = bookRent.getReturnDate();
        Date currentDate = getCurrentDate();
        if (isPastDate(returnDate)) {
            long lateDays = getDaysDifference(returnDate, currentDate);
            banEmployee(bookRent.getEmployee(), lateDays);
        }
        bookRent.setReturnDate(getCurrentDate());
        bookRent.setRating(rating);
        bookRent.setNoteAtReturn(noteAtReturn);

        bookRent.setStatus(BookRentStatus.returned);
        return bookRentMapper.toDTO(bookRentRepository.save(bookRent));
    }

    private void banEmployee(Employee employee, long lateDays){
        long banDays;
        if (lateDays < 5) {
            banDays = 10;
        } else {
            banDays = lateDays * 2;
        }
        Date banEndDate = sqlDatePlusDays(getCurrentDate(), (int) banDays);
        employee.setBanEndDate(banEndDate);
    }

    private boolean isPastDate(Date date) {
        return date.compareTo(getCurrentDate()) < 0;
    }

    private BookRent validateBookRent(int bookRentId) {
        Optional<BookRent> foundBookRent = bookRentRepository.findById(bookRentId);
        if (foundBookRent.isEmpty()) {
            throw new ResourceNotFoundException("BookRent " + bookRentId + " not found");
        }
        return foundBookRent.get();
    }

    private BookRent validateBookRentForReturn(int bookRentId) {
        BookRent bookRent = validateBookRent(bookRentId);
        if(bookRent.getStatus().equals(BookRentStatus.ongoing)){
            return bookRent;
        }else{
            throw new InvalidInputException("Book rent " + bookRentId + " must have status 'ongoing'");
        }

    }

    private Employee validateEmployee(int employeeId) {
        Optional<Employee> foundEmployee = employeeRepository.findById(employeeId);
        if (foundEmployee.isEmpty()) {
            throw new ResourceNotFoundException("Employee " + employeeId + " not found");
        }
        if (isEmployeeBanned(foundEmployee.get())) {
            throw new EmployeeException("Employee " + employeeId + " is banned until " + foundEmployee.get().getBanEndDate());
        }
        return foundEmployee.get();
    }

    private Book validateBook(int bookId) {
        Optional<Book> foundBook = bookRepository.findById(bookId);
        if (foundBook.isEmpty()) {
            throw new ResourceNotFoundException("Book " + bookId + " not found");
        }
        return foundBook.get();
    }

    private Copy getAvailableCopy(Book book) {
        Set<Copy> copies = book.getCopies();
        for (Copy copy : copies) {
            if (isCopyValid(copy)) {
                return copy;
            }
        }
        throw new ResourceNotFoundException("There are no copies available for book " + book.getId());
    }

    private boolean isCopyValid(Copy copy) {
        if (copy == null) {
            return false;
        }
        CopyState state = copy.getState();
        CopyStatus status = copy.getStatus();
        return state.equals(CopyState.good) && status.equals(CopyStatus.available);
    }

    private boolean isEmployeeBanned(Employee employee) {
        Date currentDate = getCurrentDate();
        Date banEndDate = employee.getBanEndDate();
        if (banEndDate == null) {
            return false;
        }
        return banEndDate.compareTo(currentDate) > 0;
    }

    public long getDaysDifference(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    private Date sqlDatePlusDays(Date date, int days) {
        return Date.valueOf(date.toLocalDate().plusDays(days));
    }

    private Date datePlus30Days(Date date) {
        return Date.valueOf(date.toLocalDate().plusDays(30));
    }

    private Date getCurrentDate() {
        return new Date(Calendar.getInstance().getTime().getTime());
    }

    private List<BookRentDTO> toDTOList(List<BookRent> bookRents) {
        List<BookRentDTO> dtoList = new ArrayList<>();
        for (BookRent bookRent : bookRents) {
            dtoList.add(bookRentMapper.toDTO(bookRent));
        }
        return dtoList;
    }

    private void setEntityFields(BookRent bookRent, BookRentDTO bookRentDTO) {
        bookRent.setEmployee(getEmployeeFromId(bookRent.getEmployeeId()));
        bookRent.setBook(getBookFromId(bookRent.getBookId()));
        bookRent.setCopy(getCopyFromId(bookRent.getCopyId()));

        bookRent.setRentalDate(bookRentDTO.getRentalDate());
        bookRent.setReturnDate(bookRentDTO.getReturnDate());
        bookRent.setStatus(bookRentDTO.getStatus());
        bookRent.setRating(bookRentDTO.getRating());
        bookRent.setNoteAtReturn(bookRentDTO.getNoteAtReturn());
    }

    private Employee getEmployeeFromId(int employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(IllegalArgumentException::new);
    }

    private Book getBookFromId(int bookId) {
        return bookRepository.findById(bookId).orElseThrow(IllegalArgumentException::new);
    }

    private Copy getCopyFromId(int copyId) {
        return copyRepository.findById(copyId).orElseThrow(IllegalArgumentException::new);
    }
}
