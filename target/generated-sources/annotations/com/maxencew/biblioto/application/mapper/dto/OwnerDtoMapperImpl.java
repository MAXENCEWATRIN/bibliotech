package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.request.OwnerRequest;
import com.maxencew.biblioto.application.response.OwnerResponse;
import com.maxencew.biblioto.domain.model.Owner;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T15:43:07+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class OwnerDtoMapperImpl implements OwnerDtoMapper {

    @Override
    public Owner toDomain(OwnerRequest request) throws MappingDtoException {
        if ( request == null ) {
            return null;
        }

        Long id = null;
        String firstName = null;
        String lastName = null;
        String note = null;

        id = request.getId();
        firstName = request.getFirstName();
        lastName = request.getLastName();
        note = request.getNote();

        Owner owner = new Owner( id, firstName, lastName, note );

        return owner;
    }

    @Override
    public OwnerResponse toDto(Owner owner) throws MappingDtoException {
        if ( owner == null ) {
            return null;
        }

        OwnerResponse ownerResponse = new OwnerResponse();

        ownerResponse.setId( owner.getId() );
        ownerResponse.setFirstName( owner.getFirstName() );
        ownerResponse.setLastName( owner.getLastName() );
        ownerResponse.setNote( owner.getNote() );

        return ownerResponse;
    }

    @Override
    public List<Owner> toDomainList(List<OwnerRequest> ownerRequests) throws MappingDtoException {
        if ( ownerRequests == null ) {
            return null;
        }

        List<Owner> list = new ArrayList<Owner>( ownerRequests.size() );
        for ( OwnerRequest ownerRequest : ownerRequests ) {
            list.add( toDomain( ownerRequest ) );
        }

        return list;
    }

    @Override
    public List<OwnerResponse> toDtoList(List<Owner> owners) throws MappingDtoException {
        if ( owners == null ) {
            return null;
        }

        List<OwnerResponse> list = new ArrayList<OwnerResponse>( owners.size() );
        for ( Owner owner : owners ) {
            list.add( toDto( owner ) );
        }

        return list;
    }
}
