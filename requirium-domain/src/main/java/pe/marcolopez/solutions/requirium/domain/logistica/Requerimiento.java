package pe.marcolopez.solutions.requirium.domain.logistica;

import lombok.Builder;
import lombok.Data;
import pe.marcolopez.solutions.requirium.domain.enums.RequerimientoMonedaEnum;
import pe.marcolopez.solutions.requirium.domain.enums.RequerimientoPrioridadEnum;
import pe.marcolopez.solutions.requirium.domain.enums.RequerimientoSituacionEnum;
import pe.marcolopez.solutions.requirium.domain.enums.RequerimientoTipoPagoEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@Data
public class Requerimiento {

    private Integer id;
    private String codigo;
    private LocalDateTime fecha;
    private Area area;
    private CentroCosto centroCosto;
    private Empleado solicitante;
    private LocalDate fechaRequerida;
    @Builder.Default
    private RequerimientoPrioridadEnum prioridad = RequerimientoPrioridadEnum.BAJA;
    private String asunto;
    private String sustento;
    @Builder.Default
    private RequerimientoTipoPagoEnum tipoPago = RequerimientoTipoPagoEnum.CONTADO;
    private Banco banco;
    private String cuenta;
    private LocalDateTime fechaGestionCompra;
    private LocalDateTime fechaEntregaArea;
    private LocalDateTime fechaAprobacionEvaluador;
    @Builder.Default
    private RequerimientoMonedaEnum moneda = RequerimientoMonedaEnum.SOLES;
    @Builder.Default
    private RequerimientoSituacionEnum situacion = RequerimientoSituacionEnum.PENDIENTE;
    private LocalDateTime fechaAnulacion;
    private LocalDateTime fechaCierre;
    private Empleado evaluador;
    private Empleado anulador;
    private Empleado cerrador;
}
