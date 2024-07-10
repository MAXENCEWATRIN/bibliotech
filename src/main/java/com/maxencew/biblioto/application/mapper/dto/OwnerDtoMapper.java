package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.request.OwnerRequest;
import com.maxencew.biblioto.application.response.OwnerResponse;
import com.maxencew.biblioto.domain.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerDtoMapper {

    @Mapping(target = "id", ignore = true)
    Owner toDomain(OwnerRequest request) throws MappingDtoException; 

    @Mapping(target = "books", ignore = true)
    OwnerResponse toDto(Owner owner) throws MappingDtoException; 

    List<Owner> toDomainList(List<OwnerRequest> ownerRequests) throws MappingDtoException; 

    List<OwnerResponse> toDtoList(List<Owner> owners) throws MappingDtoException;


}
