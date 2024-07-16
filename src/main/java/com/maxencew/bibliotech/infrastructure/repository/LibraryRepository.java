package com.maxencew.bibliotech.infrastructure.repository;

import com.maxencew.bibliotech.infrastructure.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {

}
