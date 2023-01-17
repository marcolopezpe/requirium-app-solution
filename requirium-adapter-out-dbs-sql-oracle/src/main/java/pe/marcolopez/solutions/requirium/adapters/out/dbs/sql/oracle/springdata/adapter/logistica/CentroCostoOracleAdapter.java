package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.adapter.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.logistica.CentroCostoMapper;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.repository.CentroCostoRepository;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.CentroCostoListPort;
import pe.marcolopez.solutions.requirium.domain.logistica.CentroCosto;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CentroCostoOracleAdapter implements CentroCostoListPort {

    private final CentroCostoRepository centroCostoRepository;
    private final CentroCostoMapper centroCostoMapper;

    @Override
    public List<CentroCosto> findAll() {
        return centroCostoMapper.toDomains(
                centroCostoRepository.findAll()
        );
    }
}
