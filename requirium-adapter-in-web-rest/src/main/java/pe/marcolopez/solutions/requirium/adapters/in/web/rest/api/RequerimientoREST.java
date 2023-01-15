package pe.marcolopez.solutions.requirium.adapters.in.web.rest.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.RequerimientoAPI;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.commons.CustomResponse;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.request.RequerimientoRequest;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.exceptions.NotFoundException;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.mappers.RequerimientoRESTMapper;
import pe.marcolopez.solutions.requirium.application.services.exception.EmpleadoException;
import pe.marcolopez.solutions.requirium.application.services.exception.RequerimientoException;
import pe.marcolopez.solutions.requirium.application.services.logistica.RequerimientoService;
import pe.marcolopez.solutions.requirium.domain.logistica.Requerimiento;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static pe.marcolopez.solutions.requirium.adapters.in.web.rest.commons.APIEndPointConst.API_REQUERIMIENTO;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(API_REQUERIMIENTO)
public class RequerimientoREST implements RequerimientoAPI {

    private final RequerimientoService requerimientoService;
    private final RequerimientoRESTMapper requerimientoRESTMapper;

    @Override
    public ResponseEntity<CustomResponse<?>> findAll() {
        List<Requerimiento> requerimientoList = requerimientoService.findAll();

        if (CollectionUtils.isEmpty(requerimientoList)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(
                CustomResponse.builder()
                        .data(
                                requerimientoList.stream()
                                        .map(requerimientoRESTMapper::toRequerimientoResponse)
                                        .collect(Collectors.toList())
                        )
                        .build()
        );
    }

    @Override
    public ResponseEntity<?> findById(Integer id) throws RequerimientoException {
        Requerimiento requerimiento = requerimientoService.findById(id);

        if (requerimiento == null) {
            throw new NotFoundException("Requerimiento con ID %s no existe!".formatted(id));
        }

        return ResponseEntity.ok(
                CustomResponse.builder()
                        .data(requerimientoRESTMapper.toRequerimientoResponse(requerimiento))
                        .build()
        );
    }

    @Override
    public ResponseEntity<CustomResponse<?>> create(RequerimientoRequest requerimientoRequest) throws RequerimientoException {
        Requerimiento requerimiento = requerimientoService.create(
                requerimientoRESTMapper.toDomain(requerimientoRequest)
        );

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(requerimiento.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<CustomResponse<?>> aprobar(Integer requerimientoId, Integer empleadoId) throws RequerimientoException, EmpleadoException {
        requerimientoService.aprobar(requerimientoId, empleadoId);

        return ResponseEntity.ok(CustomResponse.builder().build());
    }

    @Override
    public ResponseEntity<CustomResponse<?>> anular(Integer requerimientoId, Integer empleadoId) throws RequerimientoException, EmpleadoException {
        requerimientoService.anular(requerimientoId, empleadoId);

        return ResponseEntity.ok(CustomResponse.builder().build());
    }
}
