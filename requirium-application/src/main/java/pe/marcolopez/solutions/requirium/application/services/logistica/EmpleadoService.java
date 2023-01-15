package pe.marcolopez.solutions.requirium.application.services.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.application.ports.in.logistica.EmpleadoListUseCase;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.EmpleadoListPort;
import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpleadoService implements EmpleadoListUseCase {

    private final EmpleadoListPort empleadoListPort;

    @Override
    public List<Empleado> findAll() {
        return empleadoListPort.findAll();
    }
}
