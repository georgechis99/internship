package com.arobs.library.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "copy")
public class Copy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "status", nullable = false)
    private String status;

    //constructors
    public Copy() {
    }

    public Copy(String state, String status) {
        this.state = state;
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "book_id",nullable = false)
    private Book book;


}
