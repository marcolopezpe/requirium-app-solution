package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.application.services.exception.AreaException;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;

@FunctionalInterface
public interface AreaByIdUseCase {

    Area findById(Integer id) throws AreaException;
}
