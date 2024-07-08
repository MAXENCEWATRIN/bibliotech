package com.maxencew.biblioto.infrastructure.repository;

import com.maxencew.biblioto.infrastructure.entity.ThemeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<ThemeEntity, Long> {
}
