package pe.marcolopez.solutions.requirium.application.services.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.marcolopez.solutions.requirium.application.ports.in.logistica.CentroCostoListUseCase;
import pe.marcolopez.solutions.requirium.application.ports.out.logistica.CentroCostoListPort;
import pe.marcolopez.solutions.requirium.domain.logistica.CentroCosto;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CentroCostoService implements CentroCostoListUseCase {

    private final CentroCostoListPort centroCostoListPort;

    @Override
    public List<CentroCosto> findAll() {
        return centroCostoListPort.findAll();
    }
}
