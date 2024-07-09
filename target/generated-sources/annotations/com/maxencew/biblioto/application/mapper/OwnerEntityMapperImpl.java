package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.domain.model.Owner;
import com.maxencew.biblioto.infrastructure.entity.BookEntity;
import com.maxencew.biblioto.infrastructure.entity.OwnerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T00:17:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class OwnerEntityMapperImpl implements OwnerEntityMapper {

    @Override
    public OwnerEntity toEntity(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        String firstName = null;
        String lastName = null;
        String note = null;

        firstName = owner.getFirstName();
        lastName = owner.getLastName();
        note = owner.getNote();

        Long id = null;
        List<BookEntity> books = null;

        OwnerEntity ownerEntity = new OwnerEntity( id, firstName, lastName, note, books );

        return ownerEntity;
    }

    @Override
    public Owner toDomain(OwnerEntity ownerEntity) {
        if ( ownerEntity == null ) {
            return null;
        }

        Long id = null;
        String firstName = null;
        String lastName = null;
        String note = null;

        id = ownerEntity.getId();
        firstName = ownerEntity.getFirstName();
        lastName = ownerEntity.getLastName();
        note = ownerEntity.getNote();

        Owner owner = new Owner( id, firstName, lastName, note );

        return owner;
    }

    @Override
    public List<Owner> toDomainList(List<OwnerEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Owner> list = new ArrayList<Owner>( entities.size() );
        for ( OwnerEntity ownerEntity : entities ) {
            list.add( toDomain( ownerEntity ) );
        }

        return list;
    }

    @Override
    public List<OwnerEntity> toEntityList(List<Owner> owners) {
        if ( owners == null ) {
            return null;
        }

        List<OwnerEntity> list = new ArrayList<OwnerEntity>( owners.size() );
        for ( Owner owner : owners ) {
            list.add( toEntity( owner ) );
        }

        return list;
    }
}
