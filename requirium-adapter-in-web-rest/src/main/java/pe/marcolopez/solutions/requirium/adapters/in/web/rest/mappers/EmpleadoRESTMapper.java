package pe.marcolopez.solutions.requirium.adapters.in.web.rest.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.response.EmpleadoResponse;
import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;

@Component
@RequiredArgsConstructor
public class EmpleadoRESTMapper {

    private final AreaRESTMapper areaRESTMapper;

    public EmpleadoResponse toEmpleadoResponse(Empleado empleado) {
        if (empleado == null) return null;

        return EmpleadoResponse.builder()
                .id(empleado.getId())
                .nombres(empleado.getNombres())
                .apellidos(empleado.getApellidos())
                .correo(empleado.getCorreo())
                .direccion(empleado.getDireccion())
                .telefono(empleado.getTelefono())
                .area(areaRESTMapper.toAreaResponse(empleado.getArea()))
                .build();
    }
}
