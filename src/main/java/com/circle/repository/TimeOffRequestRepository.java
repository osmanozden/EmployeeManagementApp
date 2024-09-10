package com.circle.repository;

import com.circle.entity.TimeOffRequest;
import com.circle.base.data.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Repository
public interface TimeOffRequestRepository extends BaseRepository<TimeOffRequest, UUID> {
    TimeOffRequest findTimeOffRequestsByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
