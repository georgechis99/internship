package com.arobs.library.model.repository;

import com.arobs.library.model.entity.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRequestRepository extends JpaRepository<RentRequest, Integer> {
}
