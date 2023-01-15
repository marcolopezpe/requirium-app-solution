package pe.marcolopez.solutions.requirium.application.ports.out.logistica;

@FunctionalInterface
public interface RequerimientoCerrarPort {

    void cerrar(Integer requerimientoId, Integer empleadoId);
}
