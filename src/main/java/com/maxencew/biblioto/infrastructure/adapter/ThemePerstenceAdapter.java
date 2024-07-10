package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.application.mapper.entity.ThemeEntityMapper;
import com.maxencew.biblioto.domain.model.Theme;
import com.maxencew.biblioto.domain.ports.spi.ThemePersistencePort;
import com.maxencew.biblioto.infrastructure.entity.ThemeEntity;
import com.maxencew.biblioto.infrastructure.exception.AppPersistenceException;
import com.maxencew.biblioto.infrastructure.repository.ThemeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThemePerstenceAdapter implements ThemePersistencePort {

    private final ThemeRepository themeRepository;
    private final ThemeEntityMapper themeEntityMapper;

    public ThemePerstenceAdapter(ThemeRepository themeRepository, ThemeEntityMapper themeEntityMapper) {
        this.themeRepository = themeRepository;
        this.themeEntityMapper = themeEntityMapper;
    }

    @Override
    public Theme addTheme(Theme theme) {
        ThemeEntity themeEntity = themeEntityMapper.toEntity(theme);
        ThemeEntity themeEntityPersisted;
        try {
            themeEntityPersisted = themeRepository.save(themeEntity);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return  themeEntityMapper.toDomain(themeEntityPersisted);
    }

    @Override
    public void removeTheme(Theme theme) {
        ThemeEntity themeEntity = themeEntityMapper.toEntity(theme);
        try {
            themeRepository.delete(themeEntity);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Theme> getThemes() {
        List<ThemeEntity> themeEntities;
        try {
            themeEntities = themeRepository.findAll();
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return themeEntityMapper.toDomainList(themeEntities);
    }

    @Override
    public Theme getThemeById(Long themeId) {
        ThemeEntity referenceById;
        try {
            referenceById = this.themeRepository.getReferenceById(themeId);
        } catch (Exception e) {
            throw new AppPersistenceException(e.getMessage(), e);
        }
        return themeEntityMapper.toDomain(referenceById);
    }
}
