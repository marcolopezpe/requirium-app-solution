package pe.marcolopez.solutions.requirium.adapters.in.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.commons.CustomResponse;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.request.RequerimientoRequest;
import pe.marcolopez.solutions.requirium.application.services.exception.EmpleadoException;
import pe.marcolopez.solutions.requirium.application.services.exception.RequerimientoException;

@Api(value = "RequerimientoAPI")
public interface RequerimientoAPI {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "findAll")
    ResponseEntity<CustomResponse<?>> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "findById")
    ResponseEntity<?> findById(@PathVariable Integer id) throws RequerimientoException;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create")
    ResponseEntity<CustomResponse<?>> create(@RequestBody RequerimientoRequest requerimientoRequest) throws RequerimientoException;

    @PutMapping("/aprobar/{requerimientoId}/empleado/{empleadoId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "aprobar")
    ResponseEntity<CustomResponse<?>> aprobar(@PathVariable Integer requerimientoId, @PathVariable Integer empleadoId) throws RequerimientoException, EmpleadoException;

    @PutMapping("/anular/{requerimientoId}/empleado/{empleadoId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "anular")
    ResponseEntity<CustomResponse<?>> anular(@PathVariable Integer requerimientoId, @PathVariable Integer empleadoId) throws RequerimientoException, EmpleadoException;
}
