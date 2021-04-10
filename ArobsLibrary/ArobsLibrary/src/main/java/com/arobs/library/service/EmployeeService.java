package com.arobs.library.service;

import com.arobs.library.model.dto.EmployeeDTO;
import com.arobs.library.model.entity.Employee;
import com.arobs.library.model.helper.UserRole;
import com.arobs.library.model.mapper.EmployeeMapper;
import com.arobs.library.model.repository.EmployeeRepository;
import org.hibernate.DuplicateMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Validated
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Transactional
    public EmployeeDTO findById(int id) {
        Employee foundEmployee = employeeRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return employeeMapper.toDTO(foundEmployee);
    }

    @Transactional
    public Set<EmployeeDTO> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        Set<EmployeeDTO> employeeDTOs = new HashSet<>();
        for (Employee employee : employees) {
            employeeDTOs.add(employeeMapper.toDTO(employee));
        }
        return employeeDTOs;
    }

    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if(isEmployeeEnlisted(employeeDTO.getName())){
            throw new DuplicateMappingException(DuplicateMappingException.Type.ENTITY, "for Employee");
        }
        Employee employee = employeeMapper.toEntity(employeeDTO);
        return employeeMapper.toDTO(employeeRepository.save(employee));
    }

    @Transactional
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        int id = employeeDTO.getId();
        Employee foundEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));
        setEntityFields(foundEmployee,employeeDTO);
        employeeRepository.save(foundEmployee);
        return employeeMapper.toDTO(foundEmployee);
    }

    private boolean isEmployeeEnlisted(String name) {
        return employeeRepository.findByName(name) != null;
    }

    private boolean isAdmin(EmployeeDTO employeeDTO){
        return employeeDTO.getRole().equals(UserRole.admin);
    }

    private boolean isAdmin(Employee employee){
        return employee.getRole().equals(UserRole.admin);
    }

    private void setEntityFields(Employee employee, EmployeeDTO employeeDTO) {
        employee.setName(employeeDTO.getName());
        employee.setRole(employeeDTO.getRole());
        employee.setPassword(employeeDTO.getPassword());
        employee.setEmail(employeeDTO.getEmail());
        employee.setBanEndDate(employeeDTO.getBanEndDate());
    }
}
