package com.circle.repository;

import com.circle.base.data.repository.BaseRepository;
import com.circle.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee, UUID> {

    Employee findByEmail(String email);

    Employee findAllBy();

}
