package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.CentroCosto;

import java.util.List;

@FunctionalInterface
public interface CentroCostoListPort {

    List<CentroCosto> findAll();
}
