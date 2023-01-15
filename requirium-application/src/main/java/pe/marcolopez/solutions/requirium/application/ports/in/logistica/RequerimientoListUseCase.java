package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

import java.util.List;

@FunctionalInterface
public interface RequerimientoListUseCase {

    List<Requerimiento> findAll();
}
