package com.maxencew.bibliotech.application.mapper.dto;

import com.maxencew.bibliotech.application.exception.MappingDtoException;
import com.maxencew.bibliotech.application.request.OwnerRequest;
import com.maxencew.bibliotech.application.response.OwnerResponse;
import com.maxencew.bibliotech.domain.model.Owner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerDtoMapper {

    Owner toDomain(OwnerRequest request) throws MappingDtoException; 

    OwnerResponse toDto(Owner owner) throws MappingDtoException; 

    List<Owner> toDomainList(List<OwnerRequest> ownerRequests) throws MappingDtoException; 

    List<OwnerResponse> toDtoList(List<Owner> owners) throws MappingDtoException;


}
