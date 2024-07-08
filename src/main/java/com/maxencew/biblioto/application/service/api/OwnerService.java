package com.maxencew.biblioto.application.service.api;

import com.maxencew.biblioto.domain.model.Owner;

import java.util.List;

public interface OwnerService {

    Owner addOwner(Owner owner);

    void removeOwner(Owner Owner);

    List<Owner> getOwners();

    Owner getOwnerById(Long OwnerId);
}
