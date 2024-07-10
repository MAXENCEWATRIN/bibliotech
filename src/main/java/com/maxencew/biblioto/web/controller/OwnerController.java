package com.maxencew.biblioto.web.controller;

import com.maxencew.biblioto.application.mapper.dto.OwnerDtoMapper;
import com.maxencew.biblioto.application.request.OwnerRequest;
import com.maxencew.biblioto.application.response.BibliotoHttpResponse;
import com.maxencew.biblioto.application.response.OwnerResponse;
import com.maxencew.biblioto.application.service.api.OwnerService;
import jakarta.validation.Valid;
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
    public BibliotoHttpResponse<OwnerResponse> addOwner(@Valid @RequestBody OwnerRequest owner) {
        return BibliotoHttpResponse.success(ownerDtoMapper.toDto(ownerServiceAdapter.addOwner(ownerDtoMapper.toDomain(owner))));
    }

    @PutMapping("/{id}")
    public BibliotoHttpResponse<OwnerResponse> updateOwner(@PathVariable Long id, @Valid @RequestBody OwnerRequest owner) {
        owner.setId(id);
        return BibliotoHttpResponse.success(ownerDtoMapper.toDto(ownerServiceAdapter.addOwner(ownerDtoMapper.toDomain(owner))));
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id, @RequestBody OwnerRequest owner) {
        owner.setId(id);
        ownerServiceAdapter.removeOwner(ownerDtoMapper.toDomain(owner));
    }

    @GetMapping
    public BibliotoHttpResponse<List<OwnerResponse>> getAllOwners() {
        return BibliotoHttpResponse.success(ownerDtoMapper.toDtoList(ownerServiceAdapter.getOwners()));
    }

    @GetMapping("/{id}")
    public BibliotoHttpResponse<OwnerResponse> getOwnerById(@PathVariable Long id) {
        return BibliotoHttpResponse.success(ownerDtoMapper.toDto(ownerServiceAdapter.getOwnerById(id)));
    }
}
