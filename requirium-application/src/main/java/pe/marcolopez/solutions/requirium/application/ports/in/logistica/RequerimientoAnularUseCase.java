package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.application.services.exception.EmpleadoException;
import pe.marcolopez.solutions.requirium.application.services.exception.RequerimientoException;

@FunctionalInterface
public interface RequerimientoAnularUseCase {

    void anular(Integer requerimientoId, Integer empleadoId) throws RequerimientoException, EmpleadoException;
}
