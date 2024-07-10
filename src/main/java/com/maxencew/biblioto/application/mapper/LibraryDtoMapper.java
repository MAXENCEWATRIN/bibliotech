package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.application.request.LibraryRequest;
import com.maxencew.biblioto.application.response.LibraryResponse;
import com.maxencew.biblioto.domain.model.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibraryDtoMapper {

    @Mapping(target = "id", ignore = true)
    Library toDomain(LibraryRequest request);

    @Mapping(target = "books", ignore = true)
    LibraryResponse toDto(Library library);

    List<Library> toDomainList(List<LibraryRequest> librariesRequested);

    List<LibraryResponse> toDtoList(List<Library> libraries);


}
