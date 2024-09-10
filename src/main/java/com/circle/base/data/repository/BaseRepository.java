package com.circle.base.data.repository;

import com.circle.base.data.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, PK extends Serializable>
        extends PagingAndSortingRepository<T, PK>,
        JpaRepository<T, PK>,
        JpaSpecificationExecutor<T>,
        CrudRepository<T, PK> {

}
