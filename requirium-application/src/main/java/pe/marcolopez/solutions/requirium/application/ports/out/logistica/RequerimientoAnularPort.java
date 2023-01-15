package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

@FunctionalInterface
public interface RequerimientoAnularPort {

    void anular(Integer requerimientoId, Integer empleadoId);
}
