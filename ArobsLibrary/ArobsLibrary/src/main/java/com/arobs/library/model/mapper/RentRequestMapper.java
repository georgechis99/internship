package com.arobs.library.model.mapper;

import com.arobs.library.model.dto.RentRequestDTO;
import com.arobs.library.model.entity.RentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class RentRequestMapper {

    @Mapping(target = "employeeId", expression = "java(getEmployeeId(rentRequest))")
    @Mapping(target = "bookId", expression = "java(getBookId(rentRequest))")
    public abstract RentRequestDTO toDTO(RentRequest rentRequest);

    int getEmployeeId(RentRequest rentRequest) {
        return rentRequest.getEmployeeId();
    }

    int getBookId(RentRequest rentRequest) {
        return rentRequest.getBookId();
    }
}
