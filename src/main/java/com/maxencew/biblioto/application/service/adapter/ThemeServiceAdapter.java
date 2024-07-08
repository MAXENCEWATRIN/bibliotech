package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.service.api.ThemeService;
import com.maxencew.biblioto.domain.model.Theme;
import com.maxencew.biblioto.domain.ports.spi.ThemePersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class ThemeServiceAdapter implements ThemeService {

    @Autowired
    private final ThemePersistencePort themePersistencePort;

    public Theme addTheme(Theme theme) {
        return this.themePersistencePort.addTheme(theme);
    }

    public void removeTheme(Theme theme) {
        this.themePersistencePort.removeTheme(theme);
    }

    public List<Theme> getThemes() {
        return this.themePersistencePort.getThemes();
    }

    public Theme getThemeById(Long id) {
        return this.themePersistencePort.getThemeById(id);
    }

}
