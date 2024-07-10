package com.maxencew.biblioto.application.mapper.entity;

import com.maxencew.biblioto.application.exception.MappingEntityException;
import com.maxencew.biblioto.infrastructure.entity.OwnerEntity;
import com.maxencew.biblioto.domain.model.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerEntityMapper {

    @Mapping(target = "books", ignore = true)
    @Mapping(target = "id", ignore = true)
    OwnerEntity toEntity(Owner owner) throws MappingEntityException; 

    Owner toDomain(OwnerEntity ownerEntity) throws MappingEntityException; 

    List<Owner> toDomainList(List<OwnerEntity> entities) throws MappingEntityException; 

    List<OwnerEntity> toEntityList(List<Owner> owners) throws MappingEntityException;


}
