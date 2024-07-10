package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.application.request.OwnerRequest;
import com.maxencew.biblioto.application.response.OwnerResponse;
import com.maxencew.biblioto.domain.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerDtoMapper {

    @Mapping(target = "id", ignore = true)
    Owner toDomain(OwnerRequest request);

    @Mapping(target = "books", ignore = true)
    OwnerResponse toDto(Owner owner);

    List<Owner> toDomainList(List<OwnerRequest> ownerRequests);

    List<OwnerResponse> toDtoList(List<Owner> owners);


}
