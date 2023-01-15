package pe.marcolopez.solutions.requirium.adapters.in.web.rest.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.AreaAPI;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.commons.CustomResponse;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.request.AreaRequest;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.exceptions.NotFoundException;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.mappers.AreaRESTMapper;
import pe.marcolopez.solutions.requirium.application.services.exception.AreaException;
import pe.marcolopez.solutions.requirium.application.services.logistica.AreaService;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static pe.marcolopez.solutions.requirium.adapters.in.web.rest.commons.APIEndPointConst.API_AREA;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(API_AREA)
public class AreaREST implements AreaAPI {

    private final AreaService areaService;
    private final AreaRESTMapper areaRESTMapper;

    @Override
    public ResponseEntity<CustomResponse<?>> findAll() {
        List<Area> areaList = areaService.findAll();

        if (CollectionUtils.isEmpty(areaList)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(
                CustomResponse.builder()
                        .data(
                                areaList.stream()
                                        .map(areaRESTMapper::toAreaResponse)
                                        .collect(Collectors.toList())
                        )
                        .build()
        );
    }

    @Override
    public ResponseEntity<CustomResponse<?>> findById(Integer id) throws AreaException {
        Area area = areaService.findById(id);

        if (area == null) {
            throw new NotFoundException("Area con ID %s no existe!".formatted(id));
        }

        return ResponseEntity.ok(
                CustomResponse.builder()
                        .data(areaRESTMapper.toAreaResponse(area))
                        .build()
        );
    }

    @Override
    public ResponseEntity<CustomResponse<?>> create(AreaRequest areaRequest) {
        Area area = areaService.create(areaRESTMapper.toDomain(areaRequest));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(area.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<CustomResponse<?>> update(Integer id, AreaRequest areaRequest) throws AreaException {
        Area areaById = areaService.findById(id);

        if (areaById == null) {
            throw new NotFoundException("Area con ID %s no existe!".formatted(id));
        }

        return ResponseEntity.ok(
                CustomResponse.builder()
                        .data(
                                areaRESTMapper.toAreaResponse(
                                        areaService.update(areaRESTMapper.toDomain(areaRequest), id)
                                )
                        )
                        .build()
        );
    }
}
