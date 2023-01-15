package pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.adapter.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.mappers.logistica.AreaMongoMapper;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.model.logistica.AreaMongoDocument;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.repository.AreaMongoRepository;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.AreaCreateFluxPort;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.AreaListFluxPort;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class AreaMongoAdapter implements AreaListFluxPort, AreaCreateFluxPort {

    private final AreaMongoRepository areaMongoRepository;
    private final AreaMongoMapper areaMongoMapper;

    @Override
    public Flux<Area> findFluxAll() {
        return areaMongoRepository
                .findAll()
                .map(areaMongoMapper::toDomain);
    }

    @Override
    public Mono<Area> createFlux(Area area) {
        Mono<AreaMongoDocument> areaDocument = areaMongoRepository.save(areaMongoMapper.toDocument(area));
        return areaDocument.map(areaMongoMapper::toDomain);
    }
}
