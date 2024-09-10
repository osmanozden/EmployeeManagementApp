package com.circle.service;

import com.circle.base.mapper.Converter;
import com.circle.dto.EmployeeDto;
import com.circle.entity.Employee;
import com.circle.exception.EmailAlreadyExistsException;
import com.circle.exception.InvalidEmailFormatException;
import com.circle.mapper.EmployeeMapper;
import com.circle.repository.EmployeeRepository;
import com.circle.resource.EmployeeResource;
import com.circle.util.EmailValidator;
import com.circle.types.MessageTypes;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private  EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;


    public String createEmployee(@Valid Employee employee) {
            if (!EmailValidator.isValidEmail(employee.getEmail())) {
                throw new InvalidEmailFormatException(MessageTypes.INVALID_EMAIL_FORMAT.getMessage());
            }
            Optional<Employee> existingEmployee = Optional.ofNullable(employeeRepository.findByEmail(employee.getEmail()));
            if (existingEmployee.isPresent()) {
                throw new EmailAlreadyExistsException(MessageTypes.EMAIL_ALREADY_EXIST.getMessage());
            }
            if (employee.getName() == null || employee.getName().isBlank() ||
                    employee.getPosition() == null || employee.getPosition().isBlank()) {
                throw new InvalidEmailFormatException(MessageTypes.FIELD_MUST_NOT_BE_EMPTY.getMessage());
            }
            double salary = employee.getSalary();
            if (salary <= 0) {
                throw new InvalidEmailFormatException(MessageTypes.SALARY_MUST_BE_NUMBER.getMessage());
            }
            employee.setId(UUID.randomUUID());
            employee.setEmail(employee.getEmail());
            employee.setSalary(employee.getSalary());
            employeeRepository.save(employee);
            return MessageTypes.EMPLOYEE_CREATED.getMessage();
        }

    protected Converter<EmployeeDto, Employee, EmployeeResource> getConverter() {
        return this.employeeMapper;
    }

    public Optional<Employee> getEmployee(UUID id) {
        return employeeRepository.findById(id);
    }

    public String updateEmployee(Employee employee) {
        if (!EmailValidator.isValidEmail(employee.getEmail())) {
            throw new InvalidEmailFormatException(MessageTypes.INVALID_EMAIL_FORMAT.getMessage());
        }
        Optional<Employee> existingEmployee = Optional.ofNullable(employeeRepository.findByEmail(employee.getEmail()));
        if (existingEmployee.isPresent()) {
            throw new EmailAlreadyExistsException(MessageTypes.EMAIL_ALREADY_EXIST.getMessage());
        }
        if (employee.getName() == null || employee.getName().isBlank() ||
                employee.getPosition() == null || employee.getPosition().isBlank()) {
            throw new InvalidEmailFormatException(MessageTypes.FIELD_MUST_NOT_BE_EMPTY.getMessage());
        }
        double salary = employee.getSalary();
        if (salary <= 0) {
            throw new InvalidEmailFormatException(MessageTypes.SALARY_MUST_BE_NUMBER.getMessage());
        }

        employee.setEmail(employee.getEmail());
        employee.setSalary(employee.getSalary());
        employeeRepository.save(employee);
        return MessageTypes.EMPLOYEE_UPDATED.getMessage();
    }

    public String removeEmployee(UUID id) {
        if(!employeeRepository.existsById(id)) {
            MessageTypes.EMPLOYEE_NOT_FOUND.getMessage();
        }
        employeeRepository.deleteById(id);
        return MessageTypes.EMPLOYEE_DELETED_SUCCESSFULLY.getMessage();
    }
}

