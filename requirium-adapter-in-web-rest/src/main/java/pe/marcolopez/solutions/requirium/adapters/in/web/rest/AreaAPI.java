package pe.marcolopez.solutions.requirium.adapters.in.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.commons.CustomResponse;
import pe.marcolopez.solutions.requirium.adapters.in.web.rest.dto.request.AreaRequest;
import pe.marcolopez.solutions.requirium.application.services.exception.AreaException;

@Api(value = "AreaAPI")
public interface AreaAPI {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "findAll")
    ResponseEntity<CustomResponse<?>> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "findById")
    ResponseEntity<CustomResponse<?>> findById(@PathVariable Integer id) throws AreaException;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create")
    ResponseEntity<CustomResponse<?>> create(@RequestBody AreaRequest areaRequest) throws AreaException;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "update")
    ResponseEntity<CustomResponse<?>> update(@PathVariable Integer id, @RequestParam AreaRequest areaRequest) throws AreaException;
}
