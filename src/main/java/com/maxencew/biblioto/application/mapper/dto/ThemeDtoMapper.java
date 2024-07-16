package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.request.ThemeRequest;
import com.maxencew.biblioto.application.response.ThemeResponse;
import com.maxencew.biblioto.domain.model.Theme;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeDtoMapper {

    Theme toDomain(ThemeRequest request) throws MappingDtoException; 

    ThemeResponse toDto(Theme theme) throws MappingDtoException; 

    List<Theme> toDomainList(List<ThemeRequest> themeRequests) throws MappingDtoException; 

    List<ThemeResponse> toDtoList(List<Theme> themes) throws MappingDtoException;


}
