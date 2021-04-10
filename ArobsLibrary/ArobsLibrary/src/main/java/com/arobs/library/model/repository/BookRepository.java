package com.arobs.library.model.repository;

import com.arobs.library.model.entity.Author;
import com.arobs.library.model.entity.Book;
import com.arobs.library.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTagsIn(Set<Tag> tags);
    List<Book> findByAuthorsIn(Set<Author> authors);
    Book findByTitle(String title);
}
