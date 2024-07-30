package com.maxencew.bibliotech.application.web.restController;

import com.maxencew.bibliotech.application.mapper.dto.OwnerDtoMapper;
import com.maxencew.bibliotech.application.request.OwnerRequest;
import com.maxencew.bibliotech.application.response.BibliotechHttpResponse;
import com.maxencew.bibliotech.application.response.OwnerResponse;
import com.maxencew.bibliotech.domain.ports.api.OwnerService;
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
    public BibliotechHttpResponse<OwnerResponse> addOwner(@Valid @RequestBody OwnerRequest owner) {
        return BibliotechHttpResponse.success(ownerDtoMapper.toDto(ownerServiceAdapter.addOwner(ownerDtoMapper.toDomain(owner))));
    }

    @PutMapping("/{id}")
    public BibliotechHttpResponse<OwnerResponse> updateOwner(@PathVariable Long id, @Valid @RequestBody OwnerRequest owner) {
        owner.setId(id);
        return BibliotechHttpResponse.success(ownerDtoMapper.toDto(ownerServiceAdapter.addOwner(ownerDtoMapper.toDomain(owner))));
    }

    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable Long id, @RequestBody OwnerRequest owner) {
        owner.setId(id);
        ownerServiceAdapter.removeOwner(ownerDtoMapper.toDomain(owner));
    }

    @GetMapping
    public BibliotechHttpResponse<List<OwnerResponse>> getAllOwners() {
        return BibliotechHttpResponse.success(ownerDtoMapper.toDtoList(ownerServiceAdapter.getOwners()));
    }

    @GetMapping("/{id}")
    public BibliotechHttpResponse<OwnerResponse> getOwnerById(@PathVariable Long id) {
        return BibliotechHttpResponse.success(ownerDtoMapper.toDto(ownerServiceAdapter.getOwnerById(id)));
    }
}
