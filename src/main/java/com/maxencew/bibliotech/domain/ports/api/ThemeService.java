package com.maxencew.bibliotech.domain.ports.api;

import com.maxencew.bibliotech.domain.model.Theme;

import java.util.List;

public interface ThemeService {

    Theme addTheme(Theme theme);

    void removeTheme(Theme theme);

    List<Theme> getThemes();

    Theme getThemeById(Long themeId);
}
