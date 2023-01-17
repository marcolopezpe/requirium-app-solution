package pe.marcolopez.solutions.requirium.adapters.out.dbs.nosql.mongodb.springdata.adapter.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.*;
import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RequerimientoMongoAdapter implements RequerimientoListPort,
        RequerimientoByIdPort,
        RequerimientoCreatePort,
        RequerimientoAprobarPort,
        RequerimientoAnularPort,
        RequerimientoCerrarPort {

    @Override
    public void anular(Integer requerimientoId, Integer empleadoId) {

    }

    @Override
    public void aprobar(Integer requerimientoId, Integer empleadoId) {

    }

    @Override
    public Requerimiento findById(Integer id) {
        return null;
    }

    @Override
    public void cerrar(Integer requerimientoId, Integer empleadoId) {

    }

    @Override
    public Requerimiento create(Requerimiento requerimiento) {
        return null;
    }

    @Override
    public List<Requerimiento> findAll() {
        return null;
    }
}
