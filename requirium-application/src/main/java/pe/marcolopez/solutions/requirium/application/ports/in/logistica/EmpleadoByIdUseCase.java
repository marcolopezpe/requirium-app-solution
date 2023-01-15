package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;

@FunctionalInterface
public interface EmpleadoByIdUseCase {

    Empleado findById(Integer id);
}
