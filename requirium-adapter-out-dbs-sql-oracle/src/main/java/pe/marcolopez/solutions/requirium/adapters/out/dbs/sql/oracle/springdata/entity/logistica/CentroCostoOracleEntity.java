package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.base.GenericOracleEntity;

import jakarta.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity(name = "CentroCostoEntity")
@Table(name = "TBL_CENTRO_COSTO")
public class CentroCostoOracleEntity extends GenericOracleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCentroCosto")
    @SequenceGenerator(name = "seqCentroCosto", allocationSize = 1, sequenceName = "SEQ_CENTRO_COSTO")
    @Builder.Default
    private Integer id = 0;
    private String nombre;
    private String abreviado;
}
