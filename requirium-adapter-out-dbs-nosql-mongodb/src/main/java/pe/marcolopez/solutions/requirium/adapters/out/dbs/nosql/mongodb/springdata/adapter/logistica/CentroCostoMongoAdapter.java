package pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.adapter.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.CentroCostoListPort;
import pe.marcolopez.solutions.requirium.domain.logistica.CentroCosto;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CentroCostoMongoAdapter implements CentroCostoListPort {

    @Override
    public List<CentroCosto> findAll() {
        return null;
    }
}
