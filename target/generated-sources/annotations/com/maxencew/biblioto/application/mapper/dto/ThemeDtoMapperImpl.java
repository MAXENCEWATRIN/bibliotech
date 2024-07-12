package com.maxencew.biblioto.application.mapper.dto;

import com.maxencew.biblioto.application.exception.MappingDtoException;
import com.maxencew.biblioto.application.request.ThemeRequest;
import com.maxencew.biblioto.application.response.BookResponse;
import com.maxencew.biblioto.application.response.ThemeResponse;
import com.maxencew.biblioto.domain.model.Theme;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-11T21:24:48+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ThemeDtoMapperImpl implements ThemeDtoMapper {

    @Override
    public Theme toDomain(ThemeRequest request) throws MappingDtoException {
        if ( request == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        List<String> keywords = null;

        id = request.getId();
        name = request.getName();
        List<String> list = request.getKeywords();
        if ( list != null ) {
            keywords = new ArrayList<String>( list );
        }

        Theme theme = new Theme( id, name, keywords );

        return theme;
    }

    @Override
    public ThemeResponse toDto(Theme theme) throws MappingDtoException {
        if ( theme == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        List<String> keywords = null;

        id = theme.getId();
        name = theme.getName();
        List<String> list = theme.getKeywords();
        if ( list != null ) {
            keywords = new ArrayList<String>( list );
        }

        List<BookResponse> books = null;

        ThemeResponse themeResponse = new ThemeResponse( id, name, keywords, books );

        return themeResponse;
    }

    @Override
    public List<Theme> toDomainList(List<ThemeRequest> themeRequests) throws MappingDtoException {
        if ( themeRequests == null ) {
            return null;
        }

        List<Theme> list = new ArrayList<Theme>( themeRequests.size() );
        for ( ThemeRequest themeRequest : themeRequests ) {
            list.add( toDomain( themeRequest ) );
        }

        return list;
    }

    @Override
    public List<ThemeResponse> toDtoList(List<Theme> themes) throws MappingDtoException {
        if ( themes == null ) {
            return null;
        }

        List<ThemeResponse> list = new ArrayList<ThemeResponse>( themes.size() );
        for ( Theme theme : themes ) {
            list.add( toDto( theme ) );
        }

        return list;
    }
}
