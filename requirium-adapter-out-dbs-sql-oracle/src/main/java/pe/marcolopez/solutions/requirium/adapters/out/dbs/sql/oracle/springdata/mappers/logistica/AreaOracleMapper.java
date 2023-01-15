package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.logistica;

import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.AreaOracleEntity;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.base.GenericOracleMapper;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AreaOracleMapper implements GenericOracleMapper<AreaOracleEntity, Area> {

    @Override
    public Area toDomain(AreaOracleEntity areaOracleEntity) {
        if (areaOracleEntity == null) return null;

        return Area.builder()
                .id(areaOracleEntity.getId())
                .nombre(areaOracleEntity.getNombre())
                .abreviado(areaOracleEntity.getAbreviado())
                .build();
    }

    @Override
    public AreaOracleEntity toEntity(Area area) {
        if (area == null) return null;

        return AreaOracleEntity.builder()
                .id(area.getId())
                .nombre(area.getNombre())
                .abreviado(area.getAbreviado())
                .build();
    }

    @Override
    public void toEntityUpdating(Area area, AreaOracleEntity areaOracleEntity) {
        if (area == null) return;

        areaOracleEntity.setNombre(area.getNombre());
        areaOracleEntity.setAbreviado(area.getAbreviado());
    }

    @Override
    public List<Area> toDomains(List<AreaOracleEntity> areaOracleEntities) {
        if (areaOracleEntities == null) return null;

        return areaOracleEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<AreaOracleEntity> toEntities(List<Area> areas) {
        if (areas == null) return null;

        return areas.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
