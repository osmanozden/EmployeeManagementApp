package com.circle.base.mapper;


import java.util.List;


public interface Converter<DTO, Entity, Resource> {

    Resource toResource(Entity entity);

    DTO resourceToDto(Resource resource);

    List<Resource> toResource(List<Entity> entityList);

    List<DTO> toDto(List<Entity> entityList);

    Entity toEntity(DTO dto);

    DTO toDto(Entity entity);
}

