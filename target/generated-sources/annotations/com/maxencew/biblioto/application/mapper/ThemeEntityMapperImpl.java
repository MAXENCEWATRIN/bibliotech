package com.maxencew.biblioto.application.mapper;

import com.maxencew.biblioto.domain.model.Theme;
import com.maxencew.biblioto.infrastructure.entity.ThemeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T18:30:18+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ThemeEntityMapperImpl implements ThemeEntityMapper {

    @Override
    public ThemeEntity toEntity(Theme theme) {
        if ( theme == null ) {
            return null;
        }

        ThemeEntity.ThemeEntityBuilder themeEntity = ThemeEntity.builder();

        return themeEntity.build();
    }

    @Override
    public Theme toDomain(ThemeEntity theme) {
        if ( theme == null ) {
            return null;
        }

        Theme.ThemeBuilder theme1 = Theme.builder();

        return theme1.build();
    }

    @Override
    public List<Theme> toDomainList(List<ThemeEntity> entities) {
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
    public List<ThemeEntity> toEntityList(List<Theme> themes) {
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
