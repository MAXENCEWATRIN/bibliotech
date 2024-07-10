package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.infrastructure.entity.OwnerEntity;
import com.maxencew.biblioto.domain.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerEntityMapper {

    @Mapping(target = "books", ignore = true)
    @Mapping(target = "id", ignore = true)
    OwnerEntity toEntity(Owner owner);

    Owner toDomain(OwnerEntity ownerEntity);

    List<Owner> toDomainList(List<OwnerEntity> entities);

    List<OwnerEntity> toEntityList(List<Owner> owners);


}
