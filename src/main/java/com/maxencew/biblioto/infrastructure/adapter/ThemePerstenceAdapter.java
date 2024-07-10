package com.maxencew.biblioto.infrastructure.adapter;

import com.maxencew.biblioto.application.mapper.entity.ThemeEntityMapper;
import com.maxencew.biblioto.domain.model.Theme;
import com.maxencew.biblioto.domain.ports.spi.ThemePersistencePort;
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
       return  themeEntityMapper.toDomain(themeRepository.save(themeEntityMapper.toEntity(theme)));
    }

    @Override
    public void removeTheme(Theme theme) {
        themeRepository.delete(themeEntityMapper.toEntity(theme));
    }

    @Override
    public List<Theme> getThemes() {
       return themeEntityMapper.toDomainList(themeRepository.findAll());
    }

    @Override
    public Theme getThemeById(Long themeId) {
        return themeEntityMapper.toDomain(this.themeRepository.getReferenceById(themeId));
    }
}
