package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

@FunctionalInterface
public interface RequerimientoCreatePort {

    Requerimiento create(Requerimiento requerimiento);
}
