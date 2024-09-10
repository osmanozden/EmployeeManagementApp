package com.circle.mapper;

import com.circle.base.mapper.Converter;
import com.circle.dto.EmployeeDto;
import com.circle.resource.EmployeeResource;
import com.circle.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper  extends Converter<EmployeeDto, Employee, EmployeeResource> {
}
