package pe.marcolopez.solutions.requirium.domain.logistica;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public non-sealed class Empleado extends Persona {

    private Area area;
}
