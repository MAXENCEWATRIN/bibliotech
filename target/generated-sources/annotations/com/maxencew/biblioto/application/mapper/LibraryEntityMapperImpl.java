package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.domain.model.Library;
import com.maxencew.biblioto.infrastructure.entity.LibraryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T18:30:18+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class LibraryEntityMapperImpl implements LibraryEntityMapper {

    @Override
    public LibraryEntity toEntity(Library library) {
        if ( library == null ) {
            return null;
        }

        LibraryEntity.LibraryEntityBuilder libraryEntity = LibraryEntity.builder();

        return libraryEntity.build();
    }

    @Override
    public Library toDomain(LibraryEntity libraryEntity) {
        if ( libraryEntity == null ) {
            return null;
        }

        Library.LibraryBuilder library = Library.builder();

        return library.build();
    }

    @Override
    public List<Library> toDomainList(List<LibraryEntity> entities) {
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
    public List<LibraryEntity> toEntityList(List<Library> libraries) {
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
