package pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.adapter.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.EmpleadoByIdPort;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.EmpleadoListPort;
import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpleadoMongoAdapter implements EmpleadoByIdPort, EmpleadoListPort {

    @Override
    public Empleado findById(Integer id) {
        return null;
    }

    @Override
    public List<Empleado> findAll() {
        return null;
    }
}
