package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Area;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface AreaCreateFluxUseCase {

    Mono<Area> createFlux(Area area);
}
