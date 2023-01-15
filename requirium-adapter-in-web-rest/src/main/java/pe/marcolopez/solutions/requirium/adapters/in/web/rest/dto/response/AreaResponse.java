package pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AreaResponse {

    private Integer id;
    private String nombre;
    private String abreviado;
}
