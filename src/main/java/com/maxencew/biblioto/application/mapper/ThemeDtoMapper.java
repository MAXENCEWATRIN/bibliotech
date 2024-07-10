package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.application.request.ThemeRequest;
import com.maxencew.biblioto.application.response.ThemeResponse;
import com.maxencew.biblioto.domain.model.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeDtoMapper {

    @Mapping(target = "id", ignore = true)
    Theme toDomain(ThemeRequest request);

    @Mapping(target = "books", ignore = true)
    ThemeResponse toDto(Theme theme);

    List<Theme> toDomainList(List<ThemeRequest> themeRequests);

    List<ThemeResponse> toDtoList(List<Theme> themes);


}
