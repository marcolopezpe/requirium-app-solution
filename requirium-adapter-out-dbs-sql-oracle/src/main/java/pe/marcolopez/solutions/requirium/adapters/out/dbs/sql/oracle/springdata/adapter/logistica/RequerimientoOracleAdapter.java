package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.adapter.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.RequerimientoOracleEntity;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.logistica.RequerimientoOracleMapper;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.repository.RequerimientoOracleRepository;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.*;
import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RequerimientoOracleAdapter implements RequerimientoListPort,
        RequerimientoByIdPort,
        RequerimientoCreatePort,
        RequerimientoAprobarPort,
        RequerimientoAnularPort,
        RequerimientoCerrarPort {

    private final RequerimientoOracleRepository requerimientoOracleRepository;
    private final RequerimientoOracleMapper requerimientoOracleMapper;

    @Override
    public List<Requerimiento> findAll() {
        return requerimientoOracleMapper.toDomains(
                requerimientoOracleRepository.findAll()
        );
    }

    @Override
    public Requerimiento findById(Integer id) {
        Optional<RequerimientoOracleEntity> reqById = requerimientoOracleRepository.findById(id);
        return reqById
                .map(requerimientoOracleMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void anular(Integer requerimientoId, Integer empleadoId) {
        requerimientoOracleRepository.anular(requerimientoId, empleadoId);
    }

    @Override
    public void aprobar(Integer requerimientoId, Integer empleadoId) {
        requerimientoOracleRepository.aprobar(requerimientoId, empleadoId);
    }

    @Override
    public void cerrar(Integer requerimientoId, Integer empleadoId) {
        requerimientoOracleRepository.cerrar(requerimientoId, empleadoId);
    }

    @Override
    public Requerimiento create(Requerimiento requerimiento) {
        RequerimientoOracleEntity entity = requerimientoOracleMapper.toEntity(requerimiento);
        return requerimientoOracleMapper.toDomain(
                requerimientoOracleRepository.save(entity)
        );
    }
}
