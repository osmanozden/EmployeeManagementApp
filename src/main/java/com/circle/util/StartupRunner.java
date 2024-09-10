package com.circle.util;

import com.circle.entity.RequestCategory;
import com.circle.repository.RequestCategoryRepository;
import com.circle.types.RequestCategoryEnum;
import com.circle.entity.Employee;
import com.circle.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StartupRunner implements CommandLineRunner {

    private final RequestCategoryRepository requestCategoryRepository;

    private final EmployeeRepository employeeRepository;

    public StartupRunner(RequestCategoryRepository requestCategoryRepository, EmployeeRepository employeeRepository) {
        this.requestCategoryRepository = requestCategoryRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var employee = new Employee();
        employee.setId(UUID.randomUUID());
        employee.setName("Ram");
        employee.setPosition("Developer");
        employee.setSalary(10000);
        employee.setEmail("ram@123");
        employeeRepository.save(employee);

        for (RequestCategoryEnum requestCategoryEnum : RequestCategoryEnum.values()) {
            if (requestCategoryRepository.findByRequestCategoryType(requestCategoryEnum.getRequestCategoryType()) == null) {
                RequestCategory requestCategory = new RequestCategory();
                requestCategory.setRequestCategoryType(requestCategoryEnum.getRequestCategoryType());
                requestCategoryRepository.save(requestCategory);
            }
        }
    }
}
