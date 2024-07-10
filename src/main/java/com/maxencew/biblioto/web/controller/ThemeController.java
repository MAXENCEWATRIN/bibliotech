package com.maxencew.biblioto.web.controller;

import com.maxencew.biblioto.application.mapper.dto.ThemeDtoMapper;
import com.maxencew.biblioto.application.request.ThemeRequest;
import com.maxencew.biblioto.application.response.BibliotoHttpResponse;
import com.maxencew.biblioto.application.response.ThemeResponse;
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
    public BibliotoHttpResponse<ThemeResponse> addTheme(@RequestBody ThemeRequest theme) {
        return BibliotoHttpResponse.success(themeDtoMapper.toDto(themeServiceAdapter.addTheme(themeDtoMapper.toDomain(theme))));
    }

    @PutMapping("/{id}")
    public BibliotoHttpResponse<ThemeResponse> updateTheme(@PathVariable Long id, @RequestBody ThemeRequest theme) {
        theme.setId(id);
        return BibliotoHttpResponse.success(themeDtoMapper.toDto(themeServiceAdapter.addTheme(themeDtoMapper.toDomain(theme))));
    }

    @DeleteMapping("/{id}")
    public void deleteTheme(@PathVariable Long id, @RequestBody ThemeRequest theme) {
        theme.setId(id);
        themeServiceAdapter.removeTheme(themeDtoMapper.toDomain(theme));
    }

    @GetMapping
    public BibliotoHttpResponse<List<ThemeResponse>> getAllThemes() {
        return BibliotoHttpResponse.success(themeDtoMapper.toDtoList(themeServiceAdapter.getThemes()));
    }

    @GetMapping("/{id}")
    public BibliotoHttpResponse<ThemeResponse> getThemeById(@PathVariable Long id) {
        return BibliotoHttpResponse.success(themeDtoMapper.toDto(themeServiceAdapter.getThemeById(id)));
    }

}
