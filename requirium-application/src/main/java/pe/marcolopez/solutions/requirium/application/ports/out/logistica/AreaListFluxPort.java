package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Area;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface AreaListFluxPort {

    Flux<Area> findFluxAll();
}
