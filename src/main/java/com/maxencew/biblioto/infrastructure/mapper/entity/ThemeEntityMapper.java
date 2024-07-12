package com.maxencew.biblioto.infrastructure.mapper.entity;

import com.maxencew.biblioto.application.exception.MappingEntityException;
import com.maxencew.biblioto.infrastructure.entity.ThemeEntity;
import com.maxencew.biblioto.domain.model.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeEntityMapper {

    @Mapping(target = "books", ignore = true)
    ThemeEntity toEntity(Theme theme) throws MappingEntityException; 

    Theme toDomain(ThemeEntity theme) throws MappingEntityException; 

    List<Theme> toDomainList(List<ThemeEntity> entities) throws MappingEntityException; 

    List<ThemeEntity> toEntityList(List<Theme> themes) throws MappingEntityException;


}
