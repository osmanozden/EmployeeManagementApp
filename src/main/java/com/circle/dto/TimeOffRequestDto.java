package com.circle.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class TimeOffRequestDto {
    @Id
    private UUID id;

    @Id
    private UUID employeeId;

    @Id
    private UUID requestCategoryId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/M/d")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/M/d")
    private LocalDate endDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public UUID getRequestCategoryId() {
        return requestCategoryId;
    }

    public void setRequestCategoryId(UUID requestCategoryId) {
        this.requestCategoryId = requestCategoryId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
