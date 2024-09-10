package com.circle.controller;

import com.circle.entity.TimeOffRequest;
import com.circle.mapper.TimeOffRequestMapper;
import com.circle.repository.TimeOffRequestRepository;
import com.circle.resource.TimeOffRequestResource;
import com.circle.service.TimeOffRequestService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("timeoff")
public class TimeOffController {

    private final TimeOffRequestService timeOffRequestService;
    private final TimeOffRequestMapper timeOffRequestMapper;
    private final TimeOffRequestRepository timeOffRequestRepository;

    public TimeOffController(TimeOffRequestService timeOffRequestService, TimeOffRequestMapper timeOffRequestMapper, TimeOffRequestRepository timeOffRequestRepository) {
        this.timeOffRequestService = timeOffRequestService;
        this.timeOffRequestMapper = timeOffRequestMapper;
        this.timeOffRequestRepository = timeOffRequestRepository;
    }

    @PostMapping(value = "createTimeOffRequest", produces = { MediaType.APPLICATION_JSON_VALUE})
    public String createTimeOffRequest(@Valid@RequestBody TimeOffRequestResource timeOffRequestResource){
        return timeOffRequestService.createTimeOffRequest(timeOffRequestMapper.resourceToDto(timeOffRequestResource));
    }
    @GetMapping(value = "getTimeOffRequest", produces = { MediaType.APPLICATION_JSON_VALUE})
    public Optional<TimeOffRequest> getTimeOffRequest(@RequestParam(value = "id") UUID id){
        return timeOffRequestRepository.findById(id);
    }
}
