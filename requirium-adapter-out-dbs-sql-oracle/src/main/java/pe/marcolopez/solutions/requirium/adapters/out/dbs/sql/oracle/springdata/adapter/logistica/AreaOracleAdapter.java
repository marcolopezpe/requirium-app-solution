package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.adapter.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.AreaOracleEntity;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.logistica.AreaOracleMapper;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.repository.AreaOracleRepository;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.*;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AreaOracleAdapter implements AreaListFluxPort, AreaCreateFluxPort, AreaListPort, AreaByIdPort, AreaCreatePort, AreaUpdatePort {

    private final AreaOracleRepository areaOracleRepository;
    private final AreaOracleMapper areaOracleMapper;

    @Override
    public List<Area> findAll() {
        return areaOracleMapper.toDomains(
                areaOracleRepository.findAll()
        );
    }

    @Override
    public Area findById(Integer id) {
        Optional<AreaOracleEntity> areaById = areaOracleRepository.findById(id);
        return areaById
                .map(areaOracleMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Area create(Area area) {
        AreaOracleEntity entity = areaOracleMapper.toEntity(area);
        return areaOracleMapper.toDomain(
                areaOracleRepository.save(entity)
        );
    }

    @Override
    public Area update(Area area, Integer id) {
        if (areaOracleRepository.findById(id).isPresent()) {
            AreaOracleEntity entityFetched = areaOracleRepository.findById(id).get();
            areaOracleMapper.toEntityUpdating(area, entityFetched);
            return areaOracleMapper.toDomain(
                    areaOracleRepository.save(entityFetched)
            );
        }
        return null;
    }

    @Override
    public Mono<Area> createFlux(Area area) {
        return null;
    }

    @Override
    public Flux<Area> findFluxAll() {
        return null;
    }
}
