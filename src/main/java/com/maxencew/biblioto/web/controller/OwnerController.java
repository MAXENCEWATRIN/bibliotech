package com.maxencew.biblioto.infrastructure.controller;

import com.maxencew.biblioto.application.mapper.OwnerDtoMapper;
import com.maxencew.biblioto.application.request.OwnerRequest;
import com.maxencew.biblioto.application.response.OwnerResponse;
import com.maxencew.biblioto.application.service.adapter.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libraries")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @Autowired
    OwnerDtoMapper ownerDtoMapper;

    @PostMapping
    public OwnerResponse addOwner(@RequestBody OwnerRequest owner) {
        return ownerDtoMapper.toDto(ownerService.add(ownerDtoMapper.toDomain(owner)));
    }

    @PutMapping("/{id}")
    public OwnerResponse updateOwner(@PathVariable Long id, @RequestBody OwnerRequest owner) {
        owner.setId(id);
        return ownerDtoMapper.toDto(ownerService.add(ownerDtoMapper.toDomain(owner)));
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id, @RequestBody OwnerRequest owner) {
        owner.setId(id);
        ownerService.delete(ownerDtoMapper.toDomain(owner));
    }

    @GetMapping
    public List<OwnerResponse> getAllOwners() {
        return ownerDtoMapper.toDtoList(ownerService.getAll());
    }

    @GetMapping("/{id}")
    public OwnerResponse getOwnerById(@PathVariable Long id) {
        return ownerDtoMapper.toDto(ownerService.getById(id));
    }
}
