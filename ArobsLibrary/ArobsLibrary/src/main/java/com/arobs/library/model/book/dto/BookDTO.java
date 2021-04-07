package com.arobs.library.model.book.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookDTO {

    private Integer id;
    private String title;
    private String description;
    private Date addedDate;
    private List<Integer> authorIds = new ArrayList<>();
    private List<Integer> tagIds = new ArrayList<>();
    private List<Integer> copyIds = new ArrayList<>();

    public BookDTO(Integer id, String title, String description, Date addedDate,
                   List<Integer> authorIds, List<Integer> tagIds, List<Integer> copyIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.addedDate = addedDate;
        this.authorIds = authorIds;
        this.tagIds = tagIds;
        this.copyIds = copyIds;
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

    public List<Integer> getAuthorIds() {
        return authorIds;
    }

    public List<Integer> getTagIds() {
        return tagIds;
    }

    public List<Integer> getCopyIds() {
        return copyIds;
    }
}