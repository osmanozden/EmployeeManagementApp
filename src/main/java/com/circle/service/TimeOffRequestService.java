package com.circle.service;

import com.circle.entity.TimeOffRequest;
import com.circle.repository.EmployeeRepository;
import com.circle.repository.RequestCategoryRepository;
import com.circle.repository.TimeOffRequestRepository;
import com.circle.dto.TimeOffRequestDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class TimeOffRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeOffRequestService.class);
    private final TimeOffRequestRepository timeOffRequestRepository;
    private final EmployeeRepository employeeRepository;
    private final RequestCategoryRepository requestCategoryRepository;

    public TimeOffRequestService(TimeOffRequestRepository timeOffRequestRepository, EmployeeRepository employeeRepository, RequestCategoryRepository requestCategoryRepository) {
        this.timeOffRequestRepository = timeOffRequestRepository;
        this.employeeRepository = employeeRepository;
        this.requestCategoryRepository = requestCategoryRepository;
    }

    public String createTimeOffRequest(@Valid TimeOffRequestDto timeOffRequestDto){
        var timeOffRequest = new TimeOffRequest();
        timeOffRequest.setRequestCategory(requestCategoryRepository.findById(timeOffRequestDto.getRequestCategoryId()).get());
        timeOffRequest.setId(UUID.randomUUID());
        timeOffRequest.setEmployee(employeeRepository.findById(timeOffRequestDto.getEmployeeId()).get());
        timeOffRequest.setStartDate(timeOffRequestDto.getStartDate());
        timeOffRequest.setEndDate(timeOffRequestDto.getEndDate());
        timeOffRequestRepository.save(timeOffRequest);

    return "ok" ;

    }
}
