package pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpleadoResponse {

    private Integer id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String direccion;
    private String telefono;
    private AreaResponse area;
}
