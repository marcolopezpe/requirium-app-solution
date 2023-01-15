package pe.marcolopez.solutions.requirium.domain.logistica;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public non-sealed class Usuario extends Persona {

    private String nombreUsuario;
    private String contrasena;
}
