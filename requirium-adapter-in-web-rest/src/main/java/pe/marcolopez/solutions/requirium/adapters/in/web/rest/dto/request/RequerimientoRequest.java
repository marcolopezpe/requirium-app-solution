package pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequerimientoRequest {

    private String codigo;
    private Long fecha;
    private Integer areaId;
    private Integer centroCostoId;
    private Integer solicitanteId;
    private Long fechaRequerida;
    private String prioridad;
    private String asunto;
    private String sustento;
}
