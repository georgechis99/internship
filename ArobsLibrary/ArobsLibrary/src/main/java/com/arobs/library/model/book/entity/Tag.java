package com.arobs.library.model.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Tag")
@Table(name = "tag")
public class Tag implements Serializable { //com.arobs.library.model.book.entity.Tag

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 25)
    @NaturalId
    private String name;

    //   book -> @ManyToMany (book_tag) -> tag
    //   book owns the association
    @ManyToMany(mappedBy = "tags",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Book> books = new HashSet<>();

    //constructors
    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

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
