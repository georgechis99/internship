package com.arobs.library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Tag")
@Table(name = "tag")
public class Tag implements Serializable { //com.arobs.library.model.Tag

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    //constructors
    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    //   book -> @ManyToMany (book_tag) -> tag
    //   book owns the association
    @ManyToMany(mappedBy = "tags")
    private Set<Book> books = new HashSet<>();


    //setters and getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    //class specific methods
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Tag)){
            return false;
        }
        return name != null && name.equals(((Tag) obj).getName());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
