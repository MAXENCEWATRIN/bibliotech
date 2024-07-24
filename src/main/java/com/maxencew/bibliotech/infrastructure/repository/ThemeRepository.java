package com.maxencew.bibliotech.infrastructure.repository;

import com.maxencew.bibliotech.infrastructure.entity.ThemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<ThemeEntity, Long> {
}
