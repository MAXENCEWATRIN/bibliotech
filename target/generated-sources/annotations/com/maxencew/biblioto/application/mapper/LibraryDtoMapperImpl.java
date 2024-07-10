package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.application.mapper.dto.LibraryDtoMapper;
import com.maxencew.biblioto.application.request.LibraryRequest;
import com.maxencew.biblioto.application.response.LibraryResponse;
import com.maxencew.biblioto.domain.model.Library;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T02:46:28+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class LibraryDtoMapperImpl implements LibraryDtoMapper {

    @Override
    public Library toDomain(LibraryRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;
        String location = null;
        Integer capacity = null;

        name = request.getName();
        location = request.getLocation();
        capacity = request.getCapacity();

        Long id = null;

        Library library = new Library( id, name, location, capacity );

        return library;
    }

    @Override
    public LibraryResponse toDto(Library library) {
        if ( library == null ) {
            return null;
        }

        LibraryResponse libraryResponse = new LibraryResponse();

        libraryResponse.setId( library.getId() );
        libraryResponse.setName( library.getName() );
        libraryResponse.setLocation( library.getLocation() );
        libraryResponse.setCapacity( library.getCapacity() );

        return libraryResponse;
    }

    @Override
    public List<Library> toDomainList(List<LibraryRequest> librariesRequested) {
        if ( librariesRequested == null ) {
            return null;
        }

        List<Library> list = new ArrayList<Library>( librariesRequested.size() );
        for ( LibraryRequest libraryRequest : librariesRequested ) {
            list.add( toDomain( libraryRequest ) );
        }

        return list;
    }

    @Override
    public List<LibraryResponse> toDtoList(List<Library> libraries) {
        if ( libraries == null ) {
            return null;
        }

        List<LibraryResponse> list = new ArrayList<LibraryResponse>( libraries.size() );
        for ( Library library : libraries ) {
            list.add( toDto( library ) );
        }

        return list;
    }
}
