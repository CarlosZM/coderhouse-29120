package com.coderhouse.session.eight.plainv2.entities;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GenericController<T extends BusinessBehaviour<T, ID>, ID> {

    private final GenericService<T, ID> genericService;

    protected GenericController(GenericService<T, ID> genericService) {
        this.genericService = genericService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T getById(@PathVariable ID id) {
        return this.genericService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<T> getAll() {
        return this.genericService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public T create(@RequestBody T create) {
        return this.genericService.create(create);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public T update(@RequestBody T toUpdate) {
        return this.genericService.update(toUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void delete(@PathVariable ID id) {
        this.genericService.delete(id);
    }
}
