package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.adapter.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.EmpleadoOracleEntity;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.logistica.EmpleadoOracleMapper;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.repository.EmpleadoOracleRepository;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.EmpleadoByIdPort;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.EmpleadoListPort;
import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpleadoOracleAdapter implements EmpleadoByIdPort, EmpleadoListPort {

    private final EmpleadoOracleRepository empleadoOracleRepository;
    private final EmpleadoOracleMapper empleadoOracleMapper;

    @Override
    public Empleado findById(Integer id) {
        Optional<EmpleadoOracleEntity> empleadoById = empleadoOracleRepository.findById(id);
        return empleadoById
                .map(empleadoOracleMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoOracleMapper.toDomains(
                empleadoOracleRepository.findAll()
        );
    }
}
