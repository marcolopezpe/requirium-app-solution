package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;

import java.util.List;

@FunctionalInterface
public interface EmpleadoListUseCase {

    List<Empleado> findAll();
}
