package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Area;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AreaCreateFluxPort {

    Mono<Area> createFlux(Area area);
}
