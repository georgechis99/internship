package com.arobs.library.model.book.repository;

import com.arobs.library.model.book.entity.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository<Copy, Integer> {
}
