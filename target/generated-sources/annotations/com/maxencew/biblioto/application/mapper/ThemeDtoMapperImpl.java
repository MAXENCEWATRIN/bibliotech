package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.application.request.ThemeRequest;
import com.maxencew.biblioto.application.response.ThemeResponse;
import com.maxencew.biblioto.domain.model.Theme;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-10T00:17:21+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ThemeDtoMapperImpl implements ThemeDtoMapper {

    @Override
    public Theme toDomain(ThemeRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;
        List<String> keywords = null;

        name = request.getName();
        List<String> list = request.getKeywords();
        if ( list != null ) {
            keywords = new ArrayList<String>( list );
        }

        Long id = null;

        Theme theme = new Theme( id, name, keywords );

        return theme;
    }

    @Override
    public ThemeResponse toDto(Theme theme) {
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

        ThemeResponse themeResponse = new ThemeResponse( id, name, keywords );

        return themeResponse;
    }

    @Override
    public List<Theme> toDomainList(List<ThemeRequest> themeRequests) {
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
    public List<ThemeResponse> toDtoList(List<Theme> themes) {
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
