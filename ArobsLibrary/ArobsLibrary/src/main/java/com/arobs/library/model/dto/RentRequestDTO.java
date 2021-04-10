package com.arobs.library.model.dto;

import com.arobs.library.model.helper.RentRequestStatus;

import java.sql.Date;

public class RentRequestDTO {

    private Integer id;
    private int employeeId;
    private int bookId;
    private Date requestDate;
    private RentRequestStatus status;

    public RentRequestDTO() {
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

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public RentRequestStatus getStatus() {
        return status;
    }

    public void setStatus(RentRequestStatus status) {
        this.status = status;
    }
}
