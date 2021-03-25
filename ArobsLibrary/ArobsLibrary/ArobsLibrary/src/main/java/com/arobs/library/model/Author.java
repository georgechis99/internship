package com.arobs.library.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author implements Serializable { //com.arobs.library.model.Author

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    //   constructors
    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    //   book -> @ManyToMany (book_author) -> author
    //   book owns the association
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    //   setters and getters
    public int getId() {
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
        if(!(obj instanceof Author)){
            return false;
        }
        return name != null && name.equals(((Author) obj).getName());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
