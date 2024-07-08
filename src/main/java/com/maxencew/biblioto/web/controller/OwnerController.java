package com.maxencew.biblioto.web.controller;

import com.maxencew.biblioto.application.mapper.OwnerDtoMapper;
import com.maxencew.biblioto.application.request.OwnerRequest;
import com.maxencew.biblioto.application.response.OwnerResponse;
import com.maxencew.biblioto.application.service.adapter.OwnerServiceAdapter;
import com.maxencew.biblioto.application.service.api.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    OwnerService ownerServiceAdapter;

    @Autowired
    OwnerDtoMapper ownerDtoMapper;

    @PostMapping
    public OwnerResponse addOwner(@RequestBody OwnerRequest owner) {
        return ownerDtoMapper.toDto(ownerServiceAdapter.addOwner(ownerDtoMapper.toDomain(owner)));
    }

    @PutMapping("/{id}")
    public OwnerResponse updateOwner(@PathVariable Long id, @RequestBody OwnerRequest owner) {
        owner.setId(id);
        return ownerDtoMapper.toDto(ownerServiceAdapter.addOwner(ownerDtoMapper.toDomain(owner)));
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id, @RequestBody OwnerRequest owner) {
        owner.setId(id);
        ownerServiceAdapter.removeOwner(ownerDtoMapper.toDomain(owner));
    }

    @GetMapping
    public List<OwnerResponse> getAllOwners() {
        return ownerDtoMapper.toDtoList(ownerServiceAdapter.getOwners());
    }

    @GetMapping("/{id}")
    public OwnerResponse getOwnerById(@PathVariable Long id) {
        return ownerDtoMapper.toDto(ownerServiceAdapter.getOwnerById(id));
    }
}
