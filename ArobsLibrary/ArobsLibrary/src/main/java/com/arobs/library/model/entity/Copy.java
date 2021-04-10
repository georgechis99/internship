package com.arobs.library.model.entity;


import com.arobs.library.model.helper.CopyState;
import com.arobs.library.model.helper.CopyStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "copy")
public class Copy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "ENUM('good', 'deteriorated', 'lost')")
    @Enumerated(EnumType.STRING)
    @NotNull
    private CopyState state;

    @Column(columnDefinition = "ENUM('available', 'rented', 'pending')")
    @Enumerated(EnumType.STRING)
    @NotNull
    private CopyStatus status;

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    @JsonBackReference
    private Book book;

    //constructors
    public Copy() {
    }

    public Copy(CopyState state, CopyStatus status, Book book) {
        this.state = state;
        this.status = status;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CopyState getState() {
        return state;
    }

    public void setState(CopyState state) {
        this.state = state;
    }

    public CopyStatus getStatus() {
        return status;
    }

    public void setStatus(CopyStatus status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Copy)) {
            return false;
        }
        return id != null && id.equals(((Copy) obj).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
