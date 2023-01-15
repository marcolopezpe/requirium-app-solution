package pe.marcolopez.solutions.requirium.application.services.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import pe.marcolopez.solutions.requirium.application.ports.in.logistica.*;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.*;
import pe.marcolopez.solutions.requirium.application.services.exception.EmpleadoException;
import pe.marcolopez.solutions.requirium.application.services.exception.RequerimientoException;
import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;
import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RequerimientoService implements RequerimientoListUseCase,
        RequerimientoCreateUseCase,
        RequerimientoAprobarUseCase,
        RequerimientoAnularUseCase,
        RequerimientoCerrarUseCase,
        RequerimientoByIdUseCase {

    private final RequerimientoListPort requerimientoListPort;
    private final RequerimientoCreatePort requerimientoSavePort;
    private final RequerimientoAprobarPort requerimientoAprobarPort;
    private final RequerimientoAnularPort requerimientoAnularPort;
    private final RequerimientoCerrarPort requerimientoCerrarPort;
    private final RequerimientoByIdPort requerimientoByIdPort;
    private final EmpleadoByIdPort empleadoByIdPort;

    @Override
    public List<Requerimiento> findAll() {
        return requerimientoListPort.findAll();
    }

    @Override
    public void anular(Integer requerimientoId, Integer empleadoId) throws RequerimientoException, EmpleadoException {
        validateDomains(requerimientoId, empleadoId);

        requerimientoAnularPort.anular(requerimientoId, empleadoId);
    }

    @Override
    public void aprobar(Integer requerimientoId, Integer empleadoId) throws RequerimientoException, EmpleadoException {
        validateDomains(requerimientoId, empleadoId);

        requerimientoAprobarPort.aprobar(requerimientoId, empleadoId);
    }

    @Override
    public void cerrar(Integer requerimientoId, Integer empleadoId) throws RequerimientoException, EmpleadoException{
        validateDomains(requerimientoId, empleadoId);

        requerimientoCerrarPort.cerrar(requerimientoId, empleadoId);
    }

    private void validateDomains(Integer requerimientoId, Integer empleadoId) throws RequerimientoException, EmpleadoException {
        Requerimiento reqById = requerimientoByIdPort.findById(requerimientoId);

        if (ObjectUtils.isEmpty(reqById)) {
            throw new RequerimientoException("El Requerimiento con ID %s no existe".formatted(requerimientoId));
        }

        Empleado empById = empleadoByIdPort.findById(empleadoId);

        if (ObjectUtils.isEmpty(empById)) {
            throw new EmpleadoException("El Empleado con ID %s no existe".formatted(empleadoId));
        }
    }

    @Override
    public Requerimiento create(Requerimiento requerimiento) {
        return requerimientoSavePort.create(requerimiento);
    }

    @Override
    public Requerimiento findById(Integer id) throws RequerimientoException {
        Requerimiento reqById = requerimientoByIdPort.findById(id);

        if (ObjectUtils.isEmpty(reqById)) {
            throw new RequerimientoException("El Requerimiento con ID %s no existe".formatted(id));
        }

        return reqById;
    }
}
