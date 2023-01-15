package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Area;

@FunctionalInterface
public interface AreaCreateUseCase {

    Area create(Area area);
}
