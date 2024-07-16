package com.maxencew.bibliotech.application.web.restController;

import com.maxencew.bibliotech.application.mapper.dto.ThemeDtoMapper;
import com.maxencew.bibliotech.application.request.ThemeRequest;
import com.maxencew.bibliotech.application.response.BibliotechHttpResponse;
import com.maxencew.bibliotech.application.response.ThemeResponse;
import com.maxencew.bibliotech.application.service.api.ThemeService;
import jakarta.validation.Valid;
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
    public BibliotechHttpResponse<ThemeResponse> addTheme(@Valid @RequestBody ThemeRequest theme) {
        return BibliotechHttpResponse.success(themeDtoMapper.toDto(themeServiceAdapter.addTheme(themeDtoMapper.toDomain(theme))));
    }

    @PutMapping("/{id}")
    public BibliotechHttpResponse<ThemeResponse> updateTheme(@PathVariable Long id, @Valid @RequestBody ThemeRequest theme) {
        theme.setId(id);
        return BibliotechHttpResponse.success(themeDtoMapper.toDto(themeServiceAdapter.addTheme(themeDtoMapper.toDomain(theme))));
    }

    @DeleteMapping("/{id}")
    public void deleteTheme(@PathVariable Long id, @RequestBody ThemeRequest theme) {
        theme.setId(id);
        themeServiceAdapter.removeTheme(themeDtoMapper.toDomain(theme));
    }

    @GetMapping
    public BibliotechHttpResponse<List<ThemeResponse>> getAllThemes() {
        return BibliotechHttpResponse.success(themeDtoMapper.toDtoList(themeServiceAdapter.getThemes()));
    }

    @GetMapping("/{id}")
    public BibliotechHttpResponse<ThemeResponse> getThemeById(@PathVariable Long id) {
        return BibliotechHttpResponse.success(themeDtoMapper.toDto(themeServiceAdapter.getThemeById(id)));
    }

}
