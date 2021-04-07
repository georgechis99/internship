package com.arobs.library.model.employee.mapper;

import com.arobs.library.model.employee.dto.EmployeeDTO;
import com.arobs.library.model.employee.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
}
