package pe.marcolopez.solutions.requirium.domain.logistica;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public sealed class Persona permits Empleado, Usuario {

    private Integer id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String direccion;
    private String telefono;
}
