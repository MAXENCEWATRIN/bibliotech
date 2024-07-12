package com.maxencew.biblioto.application.mapper.entity;

import com.maxencew.biblioto.application.exception.MappingEntityException;
import com.maxencew.biblioto.domain.model.Theme;
import com.maxencew.biblioto.infrastructure.entity.ThemeEntity;
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
public class ThemeEntityMapperImpl implements ThemeEntityMapper {

    @Override
    public ThemeEntity toEntity(Theme theme) throws MappingEntityException {
        if ( theme == null ) {
            return null;
        }

        ThemeEntity themeEntity = new ThemeEntity();

        themeEntity.setId( theme.getId() );
        themeEntity.setName( theme.getName() );
        List<String> list = theme.getKeywords();
        if ( list != null ) {
            themeEntity.setKeywords( new ArrayList<String>( list ) );
        }

        return themeEntity;
    }

    @Override
    public Theme toDomain(ThemeEntity theme) throws MappingEntityException {
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

        Theme theme1 = new Theme( id, name, keywords );

        return theme1;
    }

    @Override
    public List<Theme> toDomainList(List<ThemeEntity> entities) throws MappingEntityException {
        if ( entities == null ) {
            return null;
        }

        List<Theme> list = new ArrayList<Theme>( entities.size() );
        for ( ThemeEntity themeEntity : entities ) {
            list.add( toDomain( themeEntity ) );
        }

        return list;
    }

    @Override
    public List<ThemeEntity> toEntityList(List<Theme> themes) throws MappingEntityException {
        if ( themes == null ) {
            return null;
        }

        List<ThemeEntity> list = new ArrayList<ThemeEntity>( themes.size() );
        for ( Theme theme : themes ) {
            list.add( toEntity( theme ) );
        }

        return list;
    }
}
