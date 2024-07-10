package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.request.LibraryRequest;
import com.maxencew.biblioto.application.response.LibraryResponse;
import com.maxencew.biblioto.domain.model.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibraryDtoMapper {

    Library toDomain(LibraryRequest request) throws MappingDtoException; 

    @Mapping(target = "books", ignore = true)
    LibraryResponse toDto(Library library) throws MappingDtoException;

    List<Library> toDomainList(List<LibraryRequest> librariesRequested) throws MappingDtoException; 

    List<LibraryResponse> toDtoList(List<Library> libraries) throws MappingDtoException; 


}
