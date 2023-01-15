package pe.marcolopez.solutions.requirium.application.ports.in.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Area;

import java.util.List;

@FunctionalInterface
public interface AreaListUseCase {

    List<Area> findAll();
}
