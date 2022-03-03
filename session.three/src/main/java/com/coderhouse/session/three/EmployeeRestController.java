package com.coderhouse.session.three;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeEntity findById(@RequestHeader(name = "HEADER") String header, String query, @PathVariable Integer employeeId) {
        return this.employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeEntity> findAll() {
        return StreamSupport.stream(this.employeeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeEntity createEmployee(@Valid @RequestBody EmployeeEntity employeeEntity) {
        return this.employeeRepository.save(employeeEntity);
    }

    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeEntity updateEmployee(@PathVariable Integer employeeId, @RequestBody EmployeeEntity employeeEntity) {
        employeeEntity.setId(employeeId);
        return this.employeeRepository.save(employeeEntity);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Integer employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }
}
