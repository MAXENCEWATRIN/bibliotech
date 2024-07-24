package com.maxencew.bibliotech.application.mapper.dto;

import com.maxencew.bibliotech.application.exception.MappingDtoException;
import com.maxencew.bibliotech.application.request.LibraryRequest;
import com.maxencew.bibliotech.application.response.LibraryResponse;
import com.maxencew.bibliotech.domain.model.Library;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibraryDtoMapper {

    Library toDomain(LibraryRequest request) throws MappingDtoException; 

    LibraryResponse toDto(Library library) throws MappingDtoException;

    List<Library> toDomainList(List<LibraryRequest> librariesRequested) throws MappingDtoException; 

    List<LibraryResponse> toDtoList(List<Library> libraries) throws MappingDtoException; 


}
