package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.logistica;

import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.BancoOracleEntity;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.base.GenericOracleMapper;
import pe.marcolopez.solutions.requirium.domain.logistica.Banco;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BancoOracleMapper implements GenericOracleMapper<BancoOracleEntity, Banco> {
    @Override
    public Banco toDomain(BancoOracleEntity bancoOracleEntity) {
        if (bancoOracleEntity == null) return null;

        return Banco.builder()
                .id(bancoOracleEntity.getId())
                .nombre(bancoOracleEntity.getNombre())
                .abreviado(bancoOracleEntity.getAbreviado())
                .build();
    }

    @Override
    public BancoOracleEntity toEntity(Banco banco) {
        if (banco == null) return null;

        return BancoOracleEntity.builder()
                .id(banco.getId())
                .nombre(banco.getNombre())
                .abreviado(banco.getAbreviado())
                .build();
    }

    @Override
    public void toEntityUpdating(Banco banco, BancoOracleEntity bancoOracleEntity) {
        if (banco == null) return;

        bancoOracleEntity.setNombre(banco.getNombre());
        bancoOracleEntity.setAbreviado(banco.getAbreviado());
    }

    @Override
    public List<Banco> toDomains(List<BancoOracleEntity> bancoOracleEntities) {
        if (bancoOracleEntities == null) return null;

        return bancoOracleEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<BancoOracleEntity> toEntities(List<Banco> bancos) {
        if (bancos == null) return null;

        return bancos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
