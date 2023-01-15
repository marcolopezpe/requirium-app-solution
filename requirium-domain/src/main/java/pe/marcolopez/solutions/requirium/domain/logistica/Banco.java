package pe.marcolopez.solutions.requirium.domain.logistica;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Banco {
    Integer id;
    String nombre;
    String abreviado;
}
