package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.logistica;

import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.CentroCostoOracleEntity;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.base.GenericOracleMapper;
import pe.marcolopez.solutions.requirium.domain.logistica.CentroCosto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CentroCostoMapper implements GenericOracleMapper<CentroCostoOracleEntity, CentroCosto> {

    @Override
    public CentroCosto toDomain(CentroCostoOracleEntity centroCostoOracleEntity) {
        if (centroCostoOracleEntity == null) return null;

        return CentroCosto.builder()
                .id(centroCostoOracleEntity.getId())
                .nombre(centroCostoOracleEntity.getNombre())
                .abreviado(centroCostoOracleEntity.getAbreviado())
                .build();
    }

    @Override
    public CentroCostoOracleEntity toEntity(CentroCosto centroCosto) {
        if (centroCosto == null) return null;

        return CentroCostoOracleEntity.builder()
                .id(centroCosto.getId())
                .nombre(centroCosto.getNombre())
                .abreviado(centroCosto.getAbreviado())
                .build();
    }

    @Override
    public void toEntityUpdating(CentroCosto centroCosto, CentroCostoOracleEntity centroCostoOracleEntity) {
        if (centroCosto == null) return;

        centroCostoOracleEntity.setNombre(centroCosto.getNombre());
        centroCostoOracleEntity.setAbreviado(centroCosto.getAbreviado());
    }

    @Override
    public List<CentroCosto> toDomains(List<CentroCostoOracleEntity> centroCostoOracleEntities) {
        if (centroCostoOracleEntities == null) return null;

        return centroCostoOracleEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<CentroCostoOracleEntity> toEntities(List<CentroCosto> centroCostos) {
        if (centroCostos == null) return null;

        return centroCostos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
