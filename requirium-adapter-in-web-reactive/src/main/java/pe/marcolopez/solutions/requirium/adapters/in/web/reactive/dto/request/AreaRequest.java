package pe.marcolopez.solutions.requirium.adapters.in.web.reactive.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaRequest {

    private String nombre;
    private String abreviado;
}
