package com.maxencew.bibliotech.infrastructure.repository;

import com.maxencew.bibliotech.infrastructure.entity.EditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<EditorEntity, Long> {

}
