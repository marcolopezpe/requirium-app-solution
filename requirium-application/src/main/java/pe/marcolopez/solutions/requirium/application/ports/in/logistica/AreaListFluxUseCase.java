package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Area;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface AreaListFluxUseCase {

    Flux<Area> findFluxAll();
}
