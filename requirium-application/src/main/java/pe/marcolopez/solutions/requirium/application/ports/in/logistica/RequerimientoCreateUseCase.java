package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

@FunctionalInterface
public interface RequerimientoCreateUseCase {

    Requerimiento create(Requerimiento requerimiento);
}
