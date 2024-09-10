package com.circle.entity;

import com.circle.base.data.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "time_off_request")
@NoArgsConstructor
public class TimeOffRequest extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "request_category_id", nullable = false)
    private RequestCategory requestCategory;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false,referencedColumnName = "id")
    private Employee employee;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/M/d")
    @Column(name = "start_date" )
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/M/d")
    @Column(name = "end_date")
    private LocalDate endDate;

    public RequestCategory getRequestCategory() {
        return requestCategory;
    }

    public void setRequestCategory(RequestCategory requestCategory) {
        this.requestCategory = requestCategory;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
