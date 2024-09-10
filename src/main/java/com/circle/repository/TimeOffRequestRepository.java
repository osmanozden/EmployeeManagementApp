package com.circle.repository;

import com.circle.entity.TimeOffRequest;
import com.circle.base.data.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TimeOffRequestRepository extends BaseRepository<TimeOffRequest, UUID> {

}
