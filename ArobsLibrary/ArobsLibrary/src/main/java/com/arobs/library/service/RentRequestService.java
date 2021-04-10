package com.arobs.library.service;

import com.arobs.library.model.dto.BookRentDTO;
import com.arobs.library.model.dto.RentRequestDTO;
import com.arobs.library.model.entity.BookRent;
import com.arobs.library.model.entity.RentRequest;
import com.arobs.library.model.mapper.RentRequestMapper;
import com.arobs.library.model.repository.BookRepository;
import com.arobs.library.model.repository.EmployeeRepository;
import com.arobs.library.model.repository.RentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentRequestService {

    private RentRequestRepository rentRequestRepository;
    private BookRepository bookRepository;
    private EmployeeRepository employeeRepository;
    private RentRequestMapper rentRequestMapper;

    @Autowired
    public RentRequestService(RentRequestRepository rentRequestRepository, BookRepository bookRepository, EmployeeRepository employeeRepository, RentRequestMapper rentRequestMapper) {
        this.rentRequestRepository = rentRequestRepository;
        this.bookRepository = bookRepository;
        this.employeeRepository = employeeRepository;
        this.rentRequestMapper = rentRequestMapper;
    }

    @Transactional
    public List<RentRequestDTO> findAll() {
        List<RentRequest> rentRequests = rentRequestRepository.findAll();
        return toDTOList(rentRequests);
    }

    private List<RentRequestDTO> toDTOList(List<RentRequest> rentRequests) {
        List<RentRequestDTO> dtoList = new ArrayList<>();
        for (RentRequest rentRequest : rentRequests) {
            dtoList.add(rentRequestMapper.toDTO(rentRequest));
        }
        return dtoList;
    }
}
