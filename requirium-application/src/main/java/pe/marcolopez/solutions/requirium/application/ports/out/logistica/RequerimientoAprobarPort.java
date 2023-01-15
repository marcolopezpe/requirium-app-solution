package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

@FunctionalInterface
public interface RequerimientoAprobarPort {

    void aprobar(Integer requerimientoId, Integer empleadoId);
}
