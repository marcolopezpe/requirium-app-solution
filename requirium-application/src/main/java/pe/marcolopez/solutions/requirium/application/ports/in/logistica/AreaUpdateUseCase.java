package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Area;

@FunctionalInterface
public interface AreaUpdateUseCase {

    Area update(Area area, Integer id);
}
