package com.maxencew.bibliotech.domain.service.adapter;

import com.maxencew.bibliotech.domain.ports.api.ThemeService;
import com.maxencew.bibliotech.domain.model.Theme;
import com.maxencew.bibliotech.domain.ports.spi.ThemePersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
