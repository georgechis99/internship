package com.arobs.library.model.mapper;

import com.arobs.library.model.dto.EmployeeDTO;
import com.arobs.library.model.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
}
