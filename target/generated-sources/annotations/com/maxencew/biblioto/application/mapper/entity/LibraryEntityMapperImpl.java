package com.maxencew.biblioto.application.mapper.entity;

import com.maxencew.biblioto.application.exception.MappingEntityException;
import com.maxencew.biblioto.domain.model.Library;
import com.maxencew.biblioto.infrastructure.entity.LibraryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-12T16:56:09+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class LibraryEntityMapperImpl implements LibraryEntityMapper {

    @Override
    public LibraryEntity toEntity(Library library) throws MappingEntityException {
        if ( library == null ) {
            return null;
        }

        LibraryEntity libraryEntity = new LibraryEntity();

        libraryEntity.setId( library.getId() );
        libraryEntity.setName( library.getName() );
        libraryEntity.setLocation( library.getLocation() );
        libraryEntity.setCapacity( library.getCapacity() );

        return libraryEntity;
    }

    @Override
    public Library toDomain(LibraryEntity libraryEntity) throws MappingEntityException {
        if ( libraryEntity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String location = null;
        Integer capacity = null;

        id = libraryEntity.getId();
        name = libraryEntity.getName();
        location = libraryEntity.getLocation();
        capacity = libraryEntity.getCapacity();

        Library library = new Library( id, name, location, capacity );

        return library;
    }

    @Override
    public List<Library> toDomainList(List<LibraryEntity> entities) throws MappingEntityException {
        if ( entities == null ) {
            return null;
        }

        List<Library> list = new ArrayList<Library>( entities.size() );
        for ( LibraryEntity libraryEntity : entities ) {
            list.add( toDomain( libraryEntity ) );
        }

        return list;
    }

    @Override
    public List<LibraryEntity> toEntityList(List<Library> libraries) throws MappingEntityException {
        if ( libraries == null ) {
            return null;
        }

        List<LibraryEntity> list = new ArrayList<LibraryEntity>( libraries.size() );
        for ( Library library : libraries ) {
            list.add( toEntity( library ) );
        }

        return list;
    }
}
