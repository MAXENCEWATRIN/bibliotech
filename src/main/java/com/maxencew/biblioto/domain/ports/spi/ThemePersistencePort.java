package com.maxencew.biblioto.domain.ports.spi;

import com.maxencew.biblioto.domain.model.Theme;

import java.util.List;

public interface ThemePersistencePort {

    Theme addTheme(Theme theme);

    void removeTheme(Theme theme);

    List<Theme> getThemes();

    Theme getThemeById(Long themeId);
}
