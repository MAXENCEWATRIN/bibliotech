package com.maxencew.biblioto.application.service.adapter;

import com.maxencew.biblioto.application.mapper.ThemeEntityMapper;
import com.maxencew.biblioto.domain.model.Theme;
import com.maxencew.biblioto.infrastructure.repository.ThemeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ThemeService {

    private final ThemeRepository themeRepository;
    private final  ThemeEntityMapper themeEntityMapper;

    @Autowired
    public ThemeService(ThemeRepository themeRepository, ThemeEntityMapper themeEntityMapper) {
        this.themeRepository = themeRepository;
        this.themeEntityMapper = themeEntityMapper;
    }

    public Theme add(Theme theme) {
        return themeEntityMapper.toDomain(this.themeRepository.save(themeEntityMapper.toEntity(theme)));
    }

    public void delete(Theme theme) {
        this.themeRepository.delete(themeEntityMapper.toEntity(theme));
    }

    public List<Theme> getAll() {
        return themeEntityMapper.toDomainList(this.themeRepository.findAll());
    }

    public Theme getById(Long id) {
        return themeEntityMapper.toDomain(this.themeRepository.getReferenceById(id));
    }

}
