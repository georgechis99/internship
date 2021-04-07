package com.arobs.library.model.book.repository;

import com.arobs.library.model.book.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findByName(String name);
}
