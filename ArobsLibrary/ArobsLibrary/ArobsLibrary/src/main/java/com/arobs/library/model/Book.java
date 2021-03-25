package com.arobs.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "book")
public class Book implements Serializable { //com.arobs.library.model.Book

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "added_date", nullable = false)
    private Date addedDate;

    //   constructors
    public Book() {
    }

    public Book(String title, String description, Date addedDate, Set<Author> authors, Set<Tag> tags, Set<Copy> copies) {
        this.title = title;
        this.description = description;
        this.addedDate = addedDate;
        this.authors = authors;
        this.tags = tags;
        this.copies = copies;
    }

    //   book -> @ManyToMany (book_author) -> author
    //   book owns the association
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    //   book -> @ManyToMany (book_tag) -> tag
    //   book owns the association
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
    })
    @JoinTable(name = "book_tag",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    //   book -> @OneToMany -> copy
    @OneToMany(mappedBy = "book")
    @JoinColumn(name = "book_id")
    private Set<Copy> copies = new HashSet<>();

    //   setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAdded_date() {
        return addedDate;
    }

    public void setAdded_date(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    //   special methods for mapping (Book -> Author , Book -> Tag)

    public void addAuthor(Author author) {
        authors.add(author);
        author.getBooks().add(this);
    }

    public void removeAuthor(Author author) {
        authors.remove(author);
        author.getBooks().remove(this);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getBooks().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getBooks().remove(this);
    }

    //class specific methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        return title != null && title.equals(((Book) obj).getTitle());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
