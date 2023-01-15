package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Area;

@FunctionalInterface
public interface AreaByIdPort {

    Area findById(Integer id);
}
