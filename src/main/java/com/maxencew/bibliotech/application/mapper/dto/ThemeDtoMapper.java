package com.maxencew.bibliotech.application.mapper.dto;

import com.maxencew.bibliotech.application.exception.MappingDtoException;
import com.maxencew.bibliotech.application.request.ThemeRequest;
import com.maxencew.bibliotech.application.response.ThemeResponse;
import com.maxencew.bibliotech.domain.model.Theme;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeDtoMapper {

    Theme toDomain(ThemeRequest request) throws MappingDtoException; 

    ThemeResponse toDto(Theme theme) throws MappingDtoException; 

    List<Theme> toDomainList(List<ThemeRequest> themeRequests) throws MappingDtoException; 

    List<ThemeResponse> toDtoList(List<Theme> themes) throws MappingDtoException;


}
