package com.maxencew.bibliotech.domain.service.adapter;

import com.maxencew.bibliotech.domain.ports.api.OwnerService;
import com.maxencew.bibliotech.domain.model.Owner;
import com.maxencew.bibliotech.domain.ports.spi.OwnerPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class OwnerServiceAdapter implements OwnerService {

    private final OwnerPersistencePort ownerPersistencePort;

    public Owner addOwner(Owner owner) {
        return this.ownerPersistencePort.addOwner(owner);
    }

    public void removeOwner(Owner owner) {
        this.ownerPersistencePort.removeOwner(owner);
    }

    public List<Owner> getOwners() {
        return this.ownerPersistencePort.getOwners();
    }

    public Owner getOwnerById(Long id) {
        return this.ownerPersistencePort.getOwnerById(id);
    }


}
