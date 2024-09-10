package com.circle.repository;


import com.circle.base.data.repository.BaseRepository;
import com.circle.entity.RequestCategory;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestCategoryRepository extends BaseRepository<RequestCategory, UUID> {
    RequestCategory findByRequestCategoryType (String RequestCategoryType);
}
