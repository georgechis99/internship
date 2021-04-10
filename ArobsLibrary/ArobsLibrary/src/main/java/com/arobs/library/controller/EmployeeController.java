package com.arobs.library.controller;

import com.arobs.library.model.dto.EmployeeDTO;
import com.arobs.library.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RequestMapping(value = "/employees")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeDTO findEmployee(@PathVariable("id") Integer id) {
        return employeeService.findById(id);
    }

    @GetMapping("/findAll")
    public Set<EmployeeDTO> findAllEmployees() {
        return employeeService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable(value = "id") int id) {
        employeeService.deleteById(id);
    }

    @PostMapping
    public EmployeeDTO saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable(value = "id") int id) {
        employeeDTO.setId(id);
        return employeeService.updateEmployee(employeeDTO);
    }


}
