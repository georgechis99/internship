package com.arobs.library.model.book.dto;

import com.arobs.library.model.book.entity.Author;
import com.arobs.library.model.book.entity.Copy;
import com.arobs.library.model.book.entity.Tag;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class BookViewDTO {
    private Integer id;
    private String title;
    private String description;
    private Date addedDate;
    private Set<Author> authors = new HashSet<>();
    private Set<Tag> tags = new HashSet<>();
    private Set<Copy> copies = new HashSet<>();

    public BookViewDTO(Integer id, String title, String description, Date addedDate, Set<Author> authors, Set<Tag> tags, Set<Copy> copies) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.addedDate = addedDate;
        this.authors = authors;
        this.tags = tags;
        this.copies = copies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getAddedDate() {
        return addedDate;
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

    public Set<Copy> getCopies() {
        return copies;
    }

    public void setCopies(Set<Copy> copies) {
        this.copies = copies;
    }
}
