package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.infrastructure.entity.ThemeEntity;
import com.maxencew.biblioto.domain.model.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeEntityMapper {

    @Mapping(target = "withId", ignore = true)
    ThemeEntity toEntity(Theme theme);

    Theme toDomain(ThemeEntity theme);

    List<Theme> toDomainList(List<ThemeEntity> entities);

    List<ThemeEntity> toEntityList(List<Theme> themes);


}
