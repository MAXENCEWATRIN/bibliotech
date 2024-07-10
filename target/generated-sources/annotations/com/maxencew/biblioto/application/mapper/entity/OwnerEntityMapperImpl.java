package com.maxencew.biblioto.application.mapper.entity;

import com.maxencew.biblioto.application.exception.MappingEntityException;
import com.maxencew.biblioto.domain.model.Owner;
import com.maxencew.biblioto.infrastructure.entity.OwnerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T22:24:26+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class OwnerEntityMapperImpl implements OwnerEntityMapper {

    @Override
    public OwnerEntity toEntity(Owner owner) throws MappingEntityException {
        if ( owner == null ) {
            return null;
        }

        OwnerEntity ownerEntity = new OwnerEntity();

        ownerEntity.setFirstName( owner.getFirstName() );
        ownerEntity.setLastName( owner.getLastName() );
        ownerEntity.setNote( owner.getNote() );

        return ownerEntity;
    }

    @Override
    public Owner toDomain(OwnerEntity ownerEntity) throws MappingEntityException {
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
    public List<Owner> toDomainList(List<OwnerEntity> entities) throws MappingEntityException {
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
    public List<OwnerEntity> toEntityList(List<Owner> owners) throws MappingEntityException {
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
