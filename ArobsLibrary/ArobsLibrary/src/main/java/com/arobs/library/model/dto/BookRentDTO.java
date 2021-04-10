package com.arobs.library.model.dto;

import com.arobs.library.model.helper.BookRentStatus;

import java.sql.Date;

public class BookRentDTO {

    private Integer id;
    private int employeeId;
    private int bookId;
    private int copyId;
    private Date rentalDate;
    private Date returnDate;
    private BookRentStatus status;
    private Integer rating;
    private String noteAtReturn;

    public BookRentDTO() {
    }

    public BookRentDTO(Integer id, int employeeId, int bookId, int copyId, Date rentalDate, Date returnDate, BookRentStatus status, int rating, String noteAtReturn) {
        this.id = id;
        this.employeeId = employeeId;
        this.bookId = bookId;
        this.copyId = copyId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.status = status;
        this.rating = rating;
        this.noteAtReturn = noteAtReturn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCopyId() {
        return copyId;
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
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
}
