package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.mapper.OwnerEntityMapper;
import com.maxencew.biblioto.domain.model.Owner;
import com.maxencew.biblioto.infrastructure.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerEntityMapper ownerEntityMapper;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, OwnerEntityMapper ownerEntityMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerEntityMapper = ownerEntityMapper;
    }

    public Owner add(Owner owner) {
        return ownerEntityMapper.toDomain(this.ownerRepository.save(ownerEntityMapper.toEntity(owner)));
    }

    public void delete(Owner owner) {
        this.ownerRepository.delete(ownerEntityMapper.toEntity(owner));
    }

    public List<Owner> getAll() {
        return ownerEntityMapper.toDomainList(this.ownerRepository.findAll());
    }

    public Owner getById(Long id) {
        return ownerEntityMapper.toDomain(this.ownerRepository.getReferenceById(id));
    }
}
