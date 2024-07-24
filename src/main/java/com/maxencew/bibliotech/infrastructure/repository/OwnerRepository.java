package com.maxencew.bibliotech.infrastructure.repository;

import com.maxencew.bibliotech.infrastructure.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
}
