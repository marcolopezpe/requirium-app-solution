package pe.marcolopez.solutions.requirium.adapters.in.web.reactive.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.marcolopez.solutions.requirium.adapters.in.web.reactive.AreaAPI;
import pe.marcolopez.solutions.requirium.adapters.in.web.reactive.dto.request.AreaRequest;
import pe.marcolopez.solutions.requirium.adapters.in.web.reactive.dto.response.AreaResponse;
import pe.marcolopez.solutions.requirium.adapters.in.web.reactive.mappers.AreaRESTMapper;
import pe.marcolopez.solutions.requirium.application.services.logistica.AreaService;
import pe.marcolopez.solutions.requirium.domain.logistica.Area;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static pe.marcolopez.solutions.requirium.adapters.in.web.reactive.commons.APIEndPointConst.API_AREA;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(API_AREA)
public class AreaREST implements AreaAPI {

    private final AreaService areaService;
    private final AreaRESTMapper areaRESTMapper;

    @Override
    public Flux<AreaResponse> findAll() {
        return areaService
                .findFluxAll()
                .map(areaRESTMapper::toAreaResponse)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<AreaResponse> create(AreaRequest areaRequest) {
        Area area = areaRESTMapper.toDomain(areaRequest);
        Mono<Area> areaSaved = areaService.createFlux(area);
        return areaSaved.map(areaRESTMapper::toAreaResponse);
    }
}
