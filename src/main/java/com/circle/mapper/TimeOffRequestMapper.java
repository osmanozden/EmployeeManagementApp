package com.circle.mapper;

import com.circle.base.mapper.Converter;
import com.circle.entity.TimeOffRequest;
import com.circle.dto.TimeOffRequestDto;
import com.circle.resource.TimeOffRequestResource;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TimeOffRequestMapper extends Converter<TimeOffRequestDto, TimeOffRequest, TimeOffRequestResource> {
}
