package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.application.services.exception.RequerimientoException;
import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

@FunctionalInterface
public interface RequerimientoByIdUseCase {

    Requerimiento findById(Integer id) throws RequerimientoException;
}
