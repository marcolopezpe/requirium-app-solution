package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.base.GenericOracleEntity;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.enums.RequerimientoOracleMonedaEnum;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.enums.RequerimientoOraclePrioridadEnum;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.enums.RequerimientoOracleSituacionEnum;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.enums.RequerimientoOracleTipoPagoEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity(name = "RequerimientoEntity")
@Table(name = "TBL_REQUERIMIENTO")
public class RequerimientoOracleEntity extends GenericOracleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRequerimiento")
    @SequenceGenerator(name = "seqRequerimiento", allocationSize = 1, sequenceName = "SEQ_REQUERIMIENTO")
    @Builder.Default
    private Integer id = 0;
    private String codigo;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fecha;
    @ManyToOne(targetEntity = AreaOracleEntity.class)
    @JoinColumn(name = "AREA_ID")
    private AreaOracleEntity areaOracleEntity;
    @ManyToOne(targetEntity = CentroCostoOracleEntity.class)
    @JoinColumn(name = "CENTRO_COSTO_ID")
    private CentroCostoOracleEntity centroCostoOracleEntity;
    @ManyToOne(targetEntity = EmpleadoOracleEntity.class)
    @JoinColumn(name = "SOLICITANTE_ID")
    private EmpleadoOracleEntity solicitanteOracleEntity;
    @Column(columnDefinition = "DATE")
    private LocalDate fechaRequerida;
    @Enumerated(EnumType.STRING)
    @Column(name = "PRIORIDAD")
    private RequerimientoOraclePrioridadEnum prioridadOracleEnum = RequerimientoOraclePrioridadEnum.BAJA;
    private String asunto;
    private String sustento;
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_PAGO")
    private RequerimientoOracleTipoPagoEnum tipoPagoOracleEnum = RequerimientoOracleTipoPagoEnum.CONTADO;
    @ManyToOne(targetEntity = BancoOracleEntity.class)
    @JoinColumn(name = "BANCO_ID")
    private BancoOracleEntity bancoOracleEntity;
    private String cuenta;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaGestionCompra;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaEntregaArea;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaAprobacionEvaluador;
    @Enumerated(EnumType.STRING)
    @Column(name = "MONEDA")
    private RequerimientoOracleMonedaEnum monedaOracleEnum = RequerimientoOracleMonedaEnum.SOLES;
    @Enumerated(EnumType.STRING)
    @Column(name = "SITUACION")
    private RequerimientoOracleSituacionEnum situacionOracleEnum = RequerimientoOracleSituacionEnum.PENDIENTE;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaAnulacion;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaCierre;
    @ManyToOne(targetEntity = EmpleadoOracleEntity.class)
    @JoinColumn(name = "EVALUADOR_ID")
    private EmpleadoOracleEntity evaluadorOracleEntity;
    @ManyToOne(targetEntity = EmpleadoOracleEntity.class)
    @JoinColumn(name = "ANULADOR_ID")
    private EmpleadoOracleEntity anuladorOracleEntity;
    @ManyToOne(targetEntity = EmpleadoOracleEntity.class)
    @JoinColumn(name = "CERRADOR_ID")
    private EmpleadoOracleEntity cerradorOracleEntity;
}
