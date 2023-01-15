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
@Entity(name = "BancoEntity")
@Table(name = "TBL_BANCO")
public class BancoOracleEntity extends GenericOracleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqBanco")
    @SequenceGenerator(name = "seqBanco", allocationSize = 1, sequenceName = "SEQ_BANCO")
    @Builder.Default
    private Integer id = 0;
    private String nombre;
    private String abreviado;
}
