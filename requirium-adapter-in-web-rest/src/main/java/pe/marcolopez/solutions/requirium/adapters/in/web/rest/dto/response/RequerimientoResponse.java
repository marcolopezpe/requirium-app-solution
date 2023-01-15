package pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequerimientoResponse {

    private Integer id;
    private String codigo;
    private LocalDateTime fecha;
    private AreaResponse area;
    private CentroCostoResponse centroCosto;
    private EmpleadoResponse solicitante;
    private LocalDate fechaRequerida;
    private String prioridad;
    private String asunto;
    private String sustento;
    private String tipoPago;
    private BancoResponse banco;
    private String cuenta;
    private LocalDateTime fechaGestionCompra;
    private LocalDateTime fechaEntregaArea;
    private LocalDateTime fechaAprobacionEvaluador;
    private String moneda;
    private String situacion;
    private LocalDateTime fechaAnulacion;
    private LocalDateTime fechaCierre;
    private EmpleadoResponse evaluador;
    private EmpleadoResponse anulador;
    private EmpleadoResponse cerrador;
}
