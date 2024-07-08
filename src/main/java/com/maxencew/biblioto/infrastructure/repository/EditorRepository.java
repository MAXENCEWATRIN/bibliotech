package com.maxencew.biblioto.infrastructure.repository;

import com.maxencew.biblioto.infrastructure.entity.EditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<EditorEntity, Long> {

}
