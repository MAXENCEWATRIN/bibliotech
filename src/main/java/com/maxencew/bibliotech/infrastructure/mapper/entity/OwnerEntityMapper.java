package com.maxencew.bibliotech.infrastructure.mapper.entity;

import com.maxencew.bibliotech.application.exception.MappingEntityException;
import com.maxencew.bibliotech.domain.model.Owner;
import com.maxencew.bibliotech.infrastructure.entity.OwnerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OwnerEntityMapper {

    @Mapping(target = "books", ignore = true)
    OwnerEntity toEntity(Owner owner) throws MappingEntityException; 

    Owner toDomain(OwnerEntity ownerEntity) throws MappingEntityException; 

    List<Owner> toDomainList(List<OwnerEntity> entities) throws MappingEntityException; 

    List<OwnerEntity> toEntityList(List<Owner> owners) throws MappingEntityException;


}
