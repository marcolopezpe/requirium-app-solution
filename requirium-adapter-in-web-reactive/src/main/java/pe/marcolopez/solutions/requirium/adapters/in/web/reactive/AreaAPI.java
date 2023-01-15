package pe.marcolopez.solutions.requirium.adapters.in.web.reactive;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pe.marcolopez.solutions.requirium.adapters.in.web.reactive.dto.request.AreaRequest;
import pe.marcolopez.solutions.requirium.adapters.in.web.reactive.dto.response.AreaResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AreaAPI {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Flux<AreaResponse> findAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mono<AreaResponse> create(@RequestBody AreaRequest areaRequest);
}
