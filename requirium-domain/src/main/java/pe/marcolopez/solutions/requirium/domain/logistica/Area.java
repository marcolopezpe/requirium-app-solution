package pe.marcolopez.solutions.requirium.domain.logistica;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Area {

    Integer id;
    String nombre;
    String abreviado;
}
