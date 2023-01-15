package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;

@FunctionalInterface
public interface EmpleadoByIdPort {

    Empleado findById(Integer id);
}
