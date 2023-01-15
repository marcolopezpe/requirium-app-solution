package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

import pe.marcolopez.solutions.requirium.domain.logistica.Area;

import java.util.List;

@FunctionalInterface
public interface AreaListPort {

    List<Area> findAll();
}
