package com.maxencew.biblioto.web.controller;

import com.maxencew.biblioto.application.mapper.ThemeDtoMapper;
import com.maxencew.biblioto.application.request.ThemeRequest;
import com.maxencew.biblioto.application.response.ThemeResponse;
import com.maxencew.biblioto.application.service.adapter.ThemeServiceAdapter;
import com.maxencew.biblioto.application.service.api.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themes")
public class ThemeController {

    @Autowired
    private ThemeService themeServiceAdapter;

    @Autowired
    private ThemeDtoMapper themeDtoMapper;

    @PostMapping
    public ThemeResponse addTheme(@RequestBody ThemeRequest theme) {
        return themeDtoMapper.toDto(themeServiceAdapter.addTheme(themeDtoMapper.toDomain(theme)));
    }

    @PutMapping("/{id}")
    public ThemeResponse updateTheme(@PathVariable Long id, @RequestBody ThemeRequest theme) {
        theme.setId(id);
        return themeDtoMapper.toDto(themeServiceAdapter.addTheme(themeDtoMapper.toDomain(theme)));
    }

    @DeleteMapping("/{id}")
    public void deleteTheme(@PathVariable Long id, @RequestBody ThemeRequest theme) {
        theme.setId(id);
        themeServiceAdapter.removeTheme(themeDtoMapper.toDomain(theme));
    }

    @GetMapping
    public List<ThemeResponse> getAllThemes() {
        return themeDtoMapper.toDtoList(themeServiceAdapter.getThemes());
    }

    @GetMapping("/{id}")
    public ThemeResponse getThemeById(@PathVariable Long id) {
        return themeDtoMapper.toDto(themeServiceAdapter.getThemeById(id));
    }

}
