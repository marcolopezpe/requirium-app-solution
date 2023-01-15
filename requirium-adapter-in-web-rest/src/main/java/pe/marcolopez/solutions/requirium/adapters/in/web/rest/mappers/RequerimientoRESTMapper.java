package pe.marcolopez.solutions.requirium.adapters.in.web.rest.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.request.RequerimientoRequest;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.response.RequerimientoResponse;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.utils.ConvertUtil;
import pe.marcolopez.solutions.requirium.domain.enums.RequerimientoPrioridadEnum;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;
import pe.marcolopez.solutions.requirium.domain.logistica.CentroCosto;
import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;
import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

@Component
@RequiredArgsConstructor
public class RequerimientoRESTMapper {

    private final AreaRESTMapper areaRESTMapper;
    private final CentroCostoRESTMapper centroCostoRESTMapper;
    private final EmpleadoRESTMapper empleadoRESTMapper;
    private final BancoRESTMapper bancoRESTMapper;


    public Requerimiento toDomain(RequerimientoRequest requerimientoRequest) {
        if (requerimientoRequest == null) return null;

        return Requerimiento.builder()
                .codigo(ConvertUtil.generateCodigo())
                .fecha(ConvertUtil.toLocalDateTime(requerimientoRequest.getFecha()))
                .area(Area.builder().id(requerimientoRequest.getAreaId()).build())
                .centroCosto(CentroCosto.builder().id(requerimientoRequest.getCentroCostoId()).build())
                .solicitante(Empleado.builder().id(requerimientoRequest.getSolicitanteId()).build())
                .fechaRequerida(ConvertUtil.toLocalDate(requerimientoRequest.getFechaRequerida()))
                .prioridad(RequerimientoPrioridadEnum.valueOf(requerimientoRequest.getPrioridad()))
                .asunto(requerimientoRequest.getAsunto())
                .sustento(requerimientoRequest.getSustento())
                .build();
    }

    public RequerimientoResponse toRequerimientoResponse(Requerimiento requerimiento) {
        if (requerimiento == null) return null;

        return RequerimientoResponse.builder()
                .id(requerimiento.getId())
                .codigo(requerimiento.getCodigo())
                .fecha(requerimiento.getFecha())
                .area(areaRESTMapper.toAreaResponse(requerimiento.getArea()))
                .centroCosto(centroCostoRESTMapper.toCentroCostoResponse(requerimiento.getCentroCosto()))
                .solicitante(empleadoRESTMapper.toEmpleadoResponse(requerimiento.getSolicitante()))
                .fechaRequerida(requerimiento.getFechaRequerida())
                .prioridad(requerimiento.getPrioridad().name())
                .asunto(requerimiento.getAsunto())
                .sustento(requerimiento.getSustento())
                .tipoPago(requerimiento.getTipoPago().name())
                .banco(bancoRESTMapper.toBancoResponse(requerimiento.getBanco()))
                .cuenta(requerimiento.getCuenta())
                .fechaGestionCompra(requerimiento.getFechaGestionCompra())
                .fechaEntregaArea(requerimiento.getFechaEntregaArea())
                .fechaAprobacionEvaluador(requerimiento.getFechaAprobacionEvaluador())
                .moneda(requerimiento.getMoneda().name())
                .situacion(requerimiento.getSituacion().name())
                .fechaAnulacion(requerimiento.getFechaAnulacion())
                .fechaCierre(requerimiento.getFechaCierre())
                .evaluador(empleadoRESTMapper.toEmpleadoResponse(requerimiento.getEvaluador()))
                .anulador(empleadoRESTMapper.toEmpleadoResponse(requerimiento.getAnulador()))
                .cerrador(empleadoRESTMapper.toEmpleadoResponse(requerimiento.getCerrador()))
                .build();
    }
}
