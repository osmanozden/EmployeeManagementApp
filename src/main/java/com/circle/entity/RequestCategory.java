package com.circle.entity;

import com.circle.base.data.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Request_Category")
@NoArgsConstructor
@AllArgsConstructor
public class RequestCategory extends BaseEntity {

    @Column(name = "request_category_type")
    private String requestCategoryType;

    public String getRequestCategoryType() {
        return requestCategoryType;
    }


    @Override
    public String toString() {
        return getRequestCategoryType();
    }

    public void setRequestCategoryType(String requestCategoryType) {
        this.requestCategoryType = requestCategoryType;
    }
}
