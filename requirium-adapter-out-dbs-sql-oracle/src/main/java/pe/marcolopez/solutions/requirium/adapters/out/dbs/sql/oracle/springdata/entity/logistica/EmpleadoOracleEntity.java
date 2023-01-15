package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.base.GenericOracleEntity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity(name = "EmpleadoEntity")
@Table(name = "TBL_EMPLEADO")
public class EmpleadoOracleEntity extends GenericOracleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmpleado")
    @SequenceGenerator(name = "seqEmpleado", allocationSize = 1, sequenceName = "SEQ_EMPLEADO")
    @Builder.Default
    private Integer id = 0;
    private String nombres;
    private String apellidos;
    private String correo;
    private String direccion;
    private String telefono;
    @ManyToOne(targetEntity = AreaOracleEntity.class)
    @JoinColumn(name = "AREA_ID")
    private AreaOracleEntity areaOracleEntity;
}
