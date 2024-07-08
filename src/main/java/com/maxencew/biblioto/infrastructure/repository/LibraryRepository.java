package com.maxencew.biblioto.infrastructure.repository;

import com.maxencew.biblioto.infrastructure.entity.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {

}
