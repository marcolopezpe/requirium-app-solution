package pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AreaRequest {

    private String nombre;
    private String abreviado;
}
