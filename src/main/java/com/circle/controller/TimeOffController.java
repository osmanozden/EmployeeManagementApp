package com.circle.controller;

import com.circle.mapper.TimeOffRequestMapper;
import com.circle.resource.TimeOffRequestResource;
import com.circle.service.TimeOffRequestService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("timeoff")
public class TimeOffController {

    private final TimeOffRequestService timeOffRequestService;
    private final TimeOffRequestMapper timeOffRequestMapper;

    public TimeOffController(TimeOffRequestService timeOffRequestService, TimeOffRequestMapper timeOffRequestMapper) {
        this.timeOffRequestService = timeOffRequestService;
        this.timeOffRequestMapper = timeOffRequestMapper;
    }

    @PostMapping(value = "createTimeOffRequest", produces = { MediaType.APPLICATION_JSON_VALUE})
    public String createTimeOffRequest(@Valid@RequestBody TimeOffRequestResource timeOffRequestResource){
        return timeOffRequestService.createTimeOffRequest(timeOffRequestMapper.resourceToDto(timeOffRequestResource));
    }
}
