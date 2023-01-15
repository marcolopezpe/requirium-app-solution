package pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.logistica;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.entity.logistica.EmpleadoOracleEntity;
import pe.marcolopez.solutions.requirium.adapters.out.dbs.sql.oracle.springdata.mappers.base.GenericOracleMapper;
import pe.marcolopez.solutions.requirium.domain.logistica.Empleado;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmpleadoOracleMapper implements GenericOracleMapper<EmpleadoOracleEntity, Empleado> {

    private final AreaOracleMapper areaOracleMapper;

    @Override
    public Empleado toDomain(EmpleadoOracleEntity empleadoOracleEntity) {
        if (empleadoOracleEntity == null) return null;

        return Empleado.builder()
                .id(empleadoOracleEntity.getId())
                .nombres(empleadoOracleEntity.getNombres())
                .apellidos(empleadoOracleEntity.getApellidos())
                .correo(empleadoOracleEntity.getCorreo())
                .direccion(empleadoOracleEntity.getDireccion())
                .telefono(empleadoOracleEntity.getTelefono())
                .area(areaOracleMapper.toDomain(empleadoOracleEntity.getAreaOracleEntity()))
                .build();
    }

    @Override
    public EmpleadoOracleEntity toEntity(Empleado empleado) {
        if (empleado == null) return null;

        return EmpleadoOracleEntity.builder()
                .id(empleado.getId())
                .nombres(empleado.getNombres())
                .apellidos(empleado.getApellidos())
                .correo(empleado.getCorreo())
                .direccion(empleado.getDireccion())
                .telefono(empleado.getTelefono())
                .areaOracleEntity(areaOracleMapper.toEntity(empleado.getArea()))
                .build();
    }

    @Override
    public void toEntityUpdating(Empleado empleado, EmpleadoOracleEntity empleadoOracleEntity) {
        if (empleado == null) return;

        empleadoOracleEntity.setNombres(empleado.getNombres());
        empleadoOracleEntity.setApellidos(empleado.getApellidos());
        empleadoOracleEntity.setCorreo(empleado.getCorreo());
        empleadoOracleEntity.setDireccion(empleado.getDireccion());
        empleadoOracleEntity.setTelefono(empleado.getTelefono());
        empleadoOracleEntity.setAreaOracleEntity(
                areaOracleMapper.toEntity(empleado.getArea())
        );
    }

    @Override
    public List<Empleado> toDomains(List<EmpleadoOracleEntity> empleadoOracleEntities) {
        if (empleadoOracleEntities == null) return null;

        return empleadoOracleEntities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoOracleEntity> toEntities(List<Empleado> empleados) {
        if (empleados == null) return null;

        return empleados.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
