package com.arobs.library.model.entity;

import com.arobs.library.model.helper.RentRequestStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "rent_request")
public class RentRequest {

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

    @Column(name = "request_date")
    @NotNull
    private Date requestDate;

    @Column(columnDefinition = "ENUM('waiting_for_copy', 'waiting_for_confirmation', 'granted', 'declined')")
    @Enumerated(EnumType.STRING)
    @NotNull
    private RentRequestStatus status;

    public RentRequest() {
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

    public int getEmployeeId() {
        return employee.getId();
    }

    public int getBookId() {
        return book.getId();
    }
}
