package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.enums.RequerimientoOracleMonedaEnum;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.enums.RequerimientoOraclePrioridadEnum;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.enums.RequerimientoOracleSituacionEnum;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.enums.RequerimientoOracleTipoPagoEnum;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.RequerimientoOracleEntity;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.base.GenericOracleMapper;
import pe.marcolopez.solutions.requirium.domain.enums.RequerimientoMonedaEnum;
import pe.marcolopez.solutions.requirium.domain.enums.RequerimientoPrioridadEnum;
import pe.marcolopez.solutions.requirium.domain.enums.RequerimientoSituacionEnum;
import pe.marcolopez.solutions.requirium.domain.enums.RequerimientoTipoPagoEnum;
import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RequerimientoOracleMapper implements GenericOracleMapper<RequerimientoOracleEntity, Requerimiento> {

    private final AreaOracleMapper areaOracleMapper;
    private final CentroCostoMapper centroCostoMapper;
    private final EmpleadoOracleMapper empleadoOracleMapper;
    private final BancoOracleMapper bancoOracleMapper;

    @Override
    public Requerimiento toDomain(RequerimientoOracleEntity requerimientoOracleEntity) {
        if (requerimientoOracleEntity == null) return null;

        return Requerimiento.builder()
                .id(requerimientoOracleEntity.getId())
                .codigo(requerimientoOracleEntity.getCodigo())
                .fecha(requerimientoOracleEntity.getFecha())
                .area(areaOracleMapper.toDomain(requerimientoOracleEntity.getAreaOracleEntity()))
                .centroCosto(centroCostoMapper.toDomain(requerimientoOracleEntity.getCentroCostoOracleEntity()))
                .solicitante(empleadoOracleMapper.toDomain(requerimientoOracleEntity.getSolicitanteOracleEntity()))
                .fechaRequerida(requerimientoOracleEntity.getFechaRequerida())
                .prioridad(RequerimientoPrioridadEnum.valueOf(requerimientoOracleEntity.getPrioridadOracleEnum().name()))
                .asunto(requerimientoOracleEntity.getAsunto())
                .sustento(requerimientoOracleEntity.getSustento())
                .tipoPago(RequerimientoTipoPagoEnum.valueOf(requerimientoOracleEntity.getTipoPagoOracleEnum().name()))
                .banco(bancoOracleMapper.toDomain(requerimientoOracleEntity.getBancoOracleEntity()))
                .cuenta(requerimientoOracleEntity.getCuenta())
                .fechaGestionCompra(requerimientoOracleEntity.getFechaGestionCompra())
                .fechaEntregaArea(requerimientoOracleEntity.getFechaEntregaArea())
                .fechaAprobacionEvaluador(requerimientoOracleEntity.getFechaAprobacionEvaluador())
                .moneda(RequerimientoMonedaEnum.valueOf(requerimientoOracleEntity.getMonedaOracleEnum().name()))
                .situacion(RequerimientoSituacionEnum.valueOf(requerimientoOracleEntity.getSituacionOracleEnum().name()))
                .fechaAnulacion(requerimientoOracleEntity.getFechaAnulacion())
                .fechaCierre(requerimientoOracleEntity.getFechaCierre())
                .evaluador(empleadoOracleMapper.toDomain(requerimientoOracleEntity.getEvaluadorOracleEntity()))
                .anulador(empleadoOracleMapper.toDomain(requerimientoOracleEntity.getAnuladorOracleEntity()))
                .cerrador(empleadoOracleMapper.toDomain(requerimientoOracleEntity.getCerradorOracleEntity()))
                .build();
    }

    @Override
    public RequerimientoOracleEntity toEntity(Requerimiento requerimiento) {
        if (requerimiento == null) return null;

        return RequerimientoOracleEntity.builder()
                .id(requerimiento.getId())
                .codigo(requerimiento.getCodigo())
                .fecha(requerimiento.getFecha())
                .areaOracleEntity(areaOracleMapper.toEntity(requerimiento.getArea()))
                .centroCostoOracleEntity(centroCostoMapper.toEntity(requerimiento.getCentroCosto()))
                .solicitanteOracleEntity(empleadoOracleMapper.toEntity(requerimiento.getSolicitante()))
                .fechaRequerida(requerimiento.getFechaRequerida())
                .prioridadOracleEnum(RequerimientoOraclePrioridadEnum.valueOf(requerimiento.getPrioridad().name()))
                .asunto(requerimiento.getAsunto())
                .sustento(requerimiento.getSustento())
                .tipoPagoOracleEnum(RequerimientoOracleTipoPagoEnum.valueOf(requerimiento.getTipoPago().name()))
                .bancoOracleEntity(bancoOracleMapper.toEntity(requerimiento.getBanco()))
                .cuenta(requerimiento.getCuenta())
                .fechaGestionCompra(requerimiento.getFechaGestionCompra())
                .fechaEntregaArea(requerimiento.getFechaEntregaArea())
                .fechaAprobacionEvaluador(requerimiento.getFechaAprobacionEvaluador())
                .monedaOracleEnum(RequerimientoOracleMonedaEnum.valueOf(requerimiento.getMoneda().name()))
                .situacionOracleEnum(RequerimientoOracleSituacionEnum.valueOf(requerimiento.getSituacion().name()))
                .fechaAnulacion(requerimiento.getFechaAnulacion())
                .fechaCierre(requerimiento.getFechaCierre())
                .evaluadorOracleEntity(empleadoOracleMapper.toEntity(requerimiento.getEvaluador()))
                .anuladorOracleEntity(empleadoOracleMapper.toEntity(requerimiento.getAnulador()))
                .cerradorOracleEntity(empleadoOracleMapper.toEntity(requerimiento.getCerrador()))
                .build();
    }

    @Override
    public void toEntityUpdating(Requerimiento requerimiento, RequerimientoOracleEntity requerimientoOracleEntity) {
        if (requerimiento == null) return;
        requerimientoOracleEntity.setCodigo(requerimiento.getCodigo());
        requerimientoOracleEntity.setFecha(requerimiento.getFecha());
        requerimientoOracleEntity.setAreaOracleEntity(
                areaOracleMapper.toEntity(requerimiento.getArea())
        );
        requerimientoOracleEntity.setCentroCostoOracleEntity(
                centroCostoMapper.toEntity(requerimiento.getCentroCosto())
        );
        requerimientoOracleEntity.setSolicitanteOracleEntity(
                empleadoOracleMapper.toEntity(requerimiento.getSolicitante())
        );
        requerimientoOracleEntity.setFechaRequerida(requerimiento.getFechaRequerida());
        requerimientoOracleEntity.setPrioridadOracleEnum(RequerimientoOraclePrioridadEnum.valueOf(requerimiento.getPrioridad().name()));
        requerimientoOracleEntity.setAsunto(requerimiento.getAsunto());
        requerimientoOracleEntity.setSustento(requerimiento.getSustento());
        requerimientoOracleEntity.setTipoPagoOracleEnum(RequerimientoOracleTipoPagoEnum.valueOf(requerimiento.getTipoPago().name()));
        requerimientoOracleEntity.setBancoOracleEntity(
                bancoOracleMapper.toEntity(requerimiento.getBanco())
        );
        requerimientoOracleEntity.setCuenta(requerimiento.getCuenta());
        requerimientoOracleEntity.setFechaGestionCompra(requerimiento.getFechaGestionCompra());
        requerimientoOracleEntity.setFechaEntregaArea(requerimiento.getFechaEntregaArea());
        requerimientoOracleEntity.setFechaAprobacionEvaluador(requerimiento.getFechaAprobacionEvaluador());
        requerimientoOracleEntity.setMonedaOracleEnum(RequerimientoOracleMonedaEnum.valueOf(requerimiento.getMoneda().name()));
        requerimientoOracleEntity.setSituacionOracleEnum(RequerimientoOracleSituacionEnum.valueOf(requerimiento.getSituacion().name()));
        requerimientoOracleEntity.setFechaAnulacion(requerimiento.getFechaAnulacion());
        requerimientoOracleEntity.setFechaCierre(requerimiento.getFechaCierre());
    }

    @Override
    public List<Requerimiento> toDomains(List<RequerimientoOracleEntity> requerimientoOracleEntities) {
        if (requerimientoOracleEntities == null) return null;

        return requerimientoOracleEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<RequerimientoOracleEntity> toEntities(List<Requerimiento> requerimientos) {
        if (requerimientos == null) return null;

        return requerimientos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
