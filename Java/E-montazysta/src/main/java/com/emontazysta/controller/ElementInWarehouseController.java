package com.emontazysta.controller;

import com.emontazysta.mapper.ElementInWarehouseMapper;
import com.emontazysta.model.ElementInWarehouse;
import com.emontazysta.model.dto.ElementInWarehouseDto;
import com.emontazysta.service.ElementInWarehouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.emontazysta.configuration.Constants.API_BASE_CONSTANT;

@RestController
@AllArgsConstructor
@RequestMapping(value = API_BASE_CONSTANT + "/elementInWarehouse", produces = MediaType.APPLICATION_JSON_VALUE)
public class ElementInWarehouseController {

    private final ElementInWarehouseService service;

    @GetMapping
    @Operation(description = "Allows to get all elements in the warehouse", security = @SecurityRequirement(name = "bearer-key"))
    public List<ElementInWarehouseDto> getAllElementsInWarehouse(){
        return service.getAll().stream()
                .map(ElementInWarehouseMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    @Operation(description = "Allows to get element in warehouse by given Id.", security = @SecurityRequirement(name = "bearer-key"))
    public ElementInWarehouseDto getElementInWarehouseById(@PathVariable Long id) {
        return ElementInWarehouseMapper.toDto(service.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Allows to add new element to warehouse.", security = @SecurityRequirement(name = "bearer-key"))
    public void addElementInWarehouse(@RequestBody ElementInWarehouse element) {
        service.add(element);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Allows to delete element from warehouse by given Id.", security = @SecurityRequirement(name = "bearer-key"))
    public void deleteElementInWarehouseById(@PathVariable Long id) {
        service.delete(id);
    }
}
