package pe.marcolopez.solutions.requirium.domain.logistica;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CentroCosto {

    Integer id;
    String nombre;
    String abreviado;
}
