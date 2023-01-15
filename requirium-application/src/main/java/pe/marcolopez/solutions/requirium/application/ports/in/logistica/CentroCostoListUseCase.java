package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.CentroCosto;

import java.util.List;

@FunctionalInterface
public interface CentroCostoListUseCase {

    List<CentroCosto> findAll();
}
