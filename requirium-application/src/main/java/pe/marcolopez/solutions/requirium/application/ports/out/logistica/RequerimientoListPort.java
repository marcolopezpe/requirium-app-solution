package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

import java.util.List;

@FunctionalInterface
public interface RequerimientoListPort {

    List<Requerimiento> findAll();
}
