package com.arobs.library.model.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author implements Serializable { //com.arobs.library.model.book.entity.Author

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    //   constructors
    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    //   setters and getters
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //class specific methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Author)) {
            return false;
        }
        return name != null && name.equals(((Author) obj).getName());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
