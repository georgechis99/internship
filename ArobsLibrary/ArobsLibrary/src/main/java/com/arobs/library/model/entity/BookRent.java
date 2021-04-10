package com.arobs.library.model.entity;

import com.arobs.library.model.helper.BookRentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Optional;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "book_rent")
public class BookRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    @NotNull
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "book_id")
    @NotNull
    private Book book;

    @OneToOne
    @JoinColumn(name = "copy_id")
    @NotNull
    private Copy copy;

    @Column(name = "rental_date")
    @NotNull
    private Date rentalDate;

    @Column(name = "return_date")
    @NotNull
//    @FutureOrPresent
    private Date returnDate;

    @Column(columnDefinition = "ENUM('ongoing', 'late', 'returned')")
    @Enumerated(EnumType.STRING)
    @NotNull
    private BookRentStatus status;

    @Column(name = "rating_at_return")
//    @Size(min = 1, max = 5)
    private Integer rating;

    @Column(name = "note_at_return")
    @Size(max = 500)
    private String noteAtReturn;

    public BookRent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public BookRentStatus getStatus() {
        return status;
    }

    public void setStatus(BookRentStatus status) {
        this.status = status;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getNoteAtReturn() {
        return noteAtReturn;
    }

    public void setNoteAtReturn(String noteAtReturn) {
        this.noteAtReturn = noteAtReturn;
    }


    public int getEmployeeId(){
        return employee.getId();
    }
    public int getBookId(){
        return book.getId();
    }
    public int getCopyId(){
        return copy.getId();
    }
}
