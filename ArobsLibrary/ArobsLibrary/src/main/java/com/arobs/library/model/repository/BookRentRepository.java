package com.arobs.library.model.repository;

import com.arobs.library.model.entity.BookRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRentRepository extends JpaRepository<BookRent, Integer> {
}
