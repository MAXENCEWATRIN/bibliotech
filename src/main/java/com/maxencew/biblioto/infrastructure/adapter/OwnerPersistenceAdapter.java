package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.application.mapper.OwnerEntityMapper;
import com.maxencew.biblioto.domain.model.Owner;
import com.maxencew.biblioto.domain.ports.spi.OwnerPersistencePort;
import com.maxencew.biblioto.infrastructure.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerPersistenceAdapter implements OwnerPersistencePort {

    private final OwnerRepository ownerRepository;
    private final OwnerEntityMapper ownerEntityMapper;

    public OwnerPersistenceAdapter(OwnerRepository ownerRepository, OwnerEntityMapper ownerEntityMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerEntityMapper = ownerEntityMapper;
    }

    @Override
    public Owner addOwner(Owner owner) {
       return  ownerEntityMapper.toDomain(ownerRepository.save(ownerEntityMapper.toEntity(owner)));
    }

    @Override
    public void removeOwner(Owner owner) {
        ownerRepository.delete(ownerEntityMapper.toEntity(owner));
    }

    @Override
    public List<Owner> getOwners() {
       return ownerEntityMapper.toDomainList(ownerRepository.findAll());
    }

    @Override
    public Owner getOwnerById(Long ownerId) {
        return ownerEntityMapper.toDomain(this.ownerRepository.getReferenceById(ownerId));
    }

}
