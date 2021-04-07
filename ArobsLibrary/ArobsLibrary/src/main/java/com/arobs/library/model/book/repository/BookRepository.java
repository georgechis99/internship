package com.arobs.library.model.book.repository;

import com.arobs.library.model.book.entity.Author;
import com.arobs.library.model.book.entity.Book;
import com.arobs.library.model.book.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Set<Book> findByTagsIn(Set<Tag> tags);
    Set<Book> findByAuthorsIn(Set<Author> authors);
}
