package com.arobs.library.repository;

import java.util.List;

public interface BaseRepository<T extends Object> {
    T getById(int id);
    T getByTitle(String title);
    List<T> getByAuthorName(String name);

    List<T> getAll();
    List<T> getAllOrderedByTitleAsc();
    List<T> getAllOrderedByTitleDesc();
    List<T> getAllOrderedByAddedDateAsc();
    List<T> getAllOrderedByAddedDateDesc();

    Integer countAll();

    int insert(int authorId, String title);

    int deleteByTitle(String title);
}
