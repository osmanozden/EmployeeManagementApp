package com.circle.controller;


import com.circle.dto.EmployeeDto;
import com.circle.entity.Employee;
import com.circle.mapper.EmployeeMapper;
import com.circle.repository.EmployeeRepository;
import com.circle.service.EmployeeService;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(value = "createEmployee", produces = { MediaType.APPLICATION_JSON_VALUE})
    public String createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeMapper.toEntity(employeeDto));
    }

    @PutMapping(value = "updateEmployee", produces = { MediaType.APPLICATION_JSON_VALUE})
    public String updateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeMapper.toEntity(employeeDto));
    }

    @GetMapping(value = "getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE})
    public Optional<Employee> getEmployee(@Valid @PathVariable("id") UUID id){
        return this.employeeService.getEmployee(id);
    }

    @GetMapping("getAllEmployees")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @DeleteMapping("deleteEmployee")
    public void delete(@PathVariable("id") UUID id) {
        employeeService.removeEmployee(id);
    }
}
