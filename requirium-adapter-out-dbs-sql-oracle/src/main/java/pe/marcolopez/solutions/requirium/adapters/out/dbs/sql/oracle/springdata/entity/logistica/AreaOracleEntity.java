package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.base.GenericOracleEntity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity(name = "AreaEntity")
@Table(name = "TBL_AREA")
public class AreaOracleEntity extends GenericOracleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArea")
    @SequenceGenerator(name = "seqArea", allocationSize = 1, sequenceName = "SEQ_AREA")
    @Builder.Default
    private Integer id = 0;
    @Size(min = 4, max = 50, message = "El Nombre es obligatorio y debe ser mayor que {min} y menor que {max} caracteres.")
    private String nombre;
    @Size(min = 1, max = 5, message = "El Nombre es obligatorio y debe ser mayor que {min} y menor que {max} caracteres.")
    private String abreviado;
}
