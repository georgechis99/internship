package com.arobs.library.model.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "book")
public class Book implements Serializable { //com.arobs.library.model.book.entity.Book

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    @Size(max = 100, message = "Book title too long")
    @NotNull
    private String title;

    @Column(length = 500)
    @Size(max = 500, message = "Book description too long")
    @NotNull
    private String description;

    @Column(name = "added_date", nullable = false)
    private Date addedDate;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @JsonManagedReference
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "book_tag",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @JsonManagedReference
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Copy> copies = new HashSet<>();


    public Book() {
    }

    //   setters and getters
    public Integer getId() {
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

    public void setAddedDate(Date addedDate) {
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

    public Date getAddedDate() {
        return addedDate;
    }

    public Set<Copy> getCopies() {
        return copies;
    }

    public void setCopies(Set<Copy> copies) {
        this.copies = copies;
    }

    //   special methods for mapping (Book -> Author , Book -> Tag)
    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getBooks().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getBooks().remove(this);
    }

    public void addCopies(int numberOfCopies) {
        for (int i = 0; i < numberOfCopies; i++) {
            Copy newCopy = new Copy("good", "available", this);
            copies.add(newCopy);
            newCopy.setBook(this);
        }
    }

    public List<Integer> getAuthorIds() {
        List<Integer> authorIds = new ArrayList<>();
        for (Author author : authors) {
            authorIds.add(author.getId());
        }
        return authorIds;
    }

    public List<Integer> getTagIds() {
        List<Integer> tagIds = new ArrayList<>();
        for (Tag tag : tags) {
            tagIds.add(tag.getId());
        }
        return tagIds;
    }

    public List<Integer> getCopyIds() {
        List<Integer> copyIds = new ArrayList<>();
        for (Copy copy : copies) {
            copyIds.add(copy.getId());
        }
        return copyIds;
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
