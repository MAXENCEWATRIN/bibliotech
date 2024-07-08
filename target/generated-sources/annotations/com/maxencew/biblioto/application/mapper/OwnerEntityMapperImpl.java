package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.domain.model.Owner;
import com.maxencew.biblioto.infrastructure.entity.OwnerEntity;
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
public class OwnerEntityMapperImpl implements OwnerEntityMapper {

    @Override
    public OwnerEntity toEntity(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerEntity.OwnerEntityBuilder ownerEntity = OwnerEntity.builder();

        return ownerEntity.build();
    }

    @Override
    public Owner toDomain(OwnerEntity ownerEntity) {
        if ( ownerEntity == null ) {
            return null;
        }

        Owner.OwnerBuilder owner = Owner.builder();

        return owner.build();
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
