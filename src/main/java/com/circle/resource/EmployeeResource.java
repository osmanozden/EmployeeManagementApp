package com.circle.resource;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class EmployeeResource {

    @Id
    private UUID id;
    private String name;
    private String position;
    private String email;
    private double salary;
    private LocalDateTime createDate;


}
