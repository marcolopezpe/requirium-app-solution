package pe.marcolopez.solutions.requirium.application.services.logistica;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import pe.marcolopez.solutions.requirium.application.ports.in.logistica.*;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.*;
import pe.marcolopez.solutions.requirium.application.services.exception.AreaException;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Transactional
public class AreaService implements AreaListUseCase, AreaByIdUseCase, AreaCreateUseCase, AreaUpdateUseCase, AreaListFluxUseCase, AreaCreateFluxUseCase {

    private final AreaListPort areaListPort;
    private final AreaByIdPort areaByIdPort;
    private final AreaCreatePort areaCreatePort;
    private final AreaUpdatePort areaUpdatePort;
    private final AreaListFluxPort areaListFluxPort;
    private final AreaCreateFluxPort areaCreateFluxPort;

    public AreaService(AreaListPort areaListPort, AreaByIdPort areaByIdPort, AreaCreatePort areaCreatePort, AreaUpdatePort areaUpdatePort, AreaListFluxPort areaListFluxPort, AreaCreateFluxPort areaCreateFluxPort) {
        this.areaListPort = areaListPort;
        this.areaByIdPort = areaByIdPort;
        this.areaCreatePort = areaCreatePort;
        this.areaUpdatePort = areaUpdatePort;
        this.areaListFluxPort = areaListFluxPort;
        this.areaCreateFluxPort = areaCreateFluxPort;
    }

    @Override
    public List<Area> findAll() {
        return areaListPort.findAll();
    }

    @Override
    public Area findById(Integer id) throws AreaException {
        Area areaById = areaByIdPort.findById(id);

        if (ObjectUtils.isEmpty(areaById)) {
            throw new AreaException("El Area con ID %s existe".formatted(id));
        }

        return areaById;
    }

    @Override
    public Area create(Area area) {
        return areaCreatePort.create(area);
    }

    @Override
    public Area update(Area area, Integer id) {
        return areaUpdatePort.update(area, id);
    }

    @Override
    public Flux<Area> findFluxAll() {
        return areaListFluxPort.findFluxAll();
    }

    @Override
    public Mono<Area> createFlux(Area area) {
        return areaCreateFluxPort.createFlux(area);
    }
}
