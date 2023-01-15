package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;

import java.util.List;

@FunctionalInterface
public interface EmpleadoListPort {

    List<Empleado> findAll();
}
