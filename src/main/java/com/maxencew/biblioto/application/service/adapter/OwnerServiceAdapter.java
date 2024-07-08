package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.service.api.OwnerService;
import com.maxencew.biblioto.domain.model.Owner;
import com.maxencew.biblioto.domain.ports.spi.OwnerPersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class OwnerServiceAdapter implements OwnerService {

    @Autowired
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
