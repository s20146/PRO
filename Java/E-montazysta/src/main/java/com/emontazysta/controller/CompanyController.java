package com.emontazysta.controller;

import com.emontazysta.model.Company;
import com.emontazysta.service.impl.CompanyServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.emontazysta.configuration.Constants.API_BASE_CONSTANT;

@RestController
@AllArgsConstructor
@RequestMapping(value = API_BASE_CONSTANT + "/company", produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {

    private final CompanyServiceImpl companyService;

    @GetMapping
    @Operation(description = "Allows to get all Companies.", security = @SecurityRequirement(name = "bearer-key"))
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @GetMapping("{id}")
    @Operation(description = "Allows to get Company by given Id.", security = @SecurityRequirement(name = "bearer-key"))
    public Company getById(@PathVariable("id") Long id) {
        return companyService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Allows to add new Company.", security = @SecurityRequirement(name = "bearer-key"))
    public void add(@RequestBody Company company) {
        companyService.add(company);
    }

    @DeleteMapping("{id}")
    @Operation(description = "Allows to delete Company by given Id.", security = @SecurityRequirement(name = "bearer-key"))
    public void deleteById(@PathVariable("id") Long id) {
         companyService.delete(id);
    }

    @PutMapping("{id}")
    @Operation(description = "Allows to update Company by given Id, and Company.", security = @SecurityRequirement(name = "bearer-key"))
    public void update(@PathVariable("id") Long id,
                              @RequestBody Company company) {
        companyService.update(id, company);
    }
}
