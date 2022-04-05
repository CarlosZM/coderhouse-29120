package com.coderhouse.session.eleven.employee;

import com.coderhouse.session.eleven.schemas.AddressSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Validated
@Tag(name = "employee", description = "the user API")
public class EmployeeRestController {

    @GetMapping(value = "/{employeeId}", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get employee", description = "Get an employee by id", tags = {"employee"})
    @ApiResponses(value = {@ApiResponse(description = "successful operation", responseCode = "200")})
    public EmployeeEntity findById(@RequestHeader(name = "HEADER") String header, String query, @PathVariable Integer employeeId) {
        return new EmployeeEntity();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeEntity> findAll() {
        return Collections.emptyList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeEntity createEmployee(@Valid @RequestBody EmployeeEntity employeeEntity) {
        return employeeEntity;
    }

    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeEntity updateEmployee(@PathVariable Integer employeeId, @RequestBody EmployeeEntity employeeEntity) {
        return employeeEntity;
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Deprecated
    public void deleteEmployee(@PathVariable Integer employeeId) {

    }
}
