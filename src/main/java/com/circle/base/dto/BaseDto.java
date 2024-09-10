package com.circle.base.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class BaseDto implements Serializable {
    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDto baseDto = (BaseDto) o;
        return Objects.equals(id, baseDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "BaseDto{" +
                "id=" + id +
                '}';
    }

    public void setId(UUID id) {
        this.id = id;
    }

    protected UUID id;
}
