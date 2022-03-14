package com.coderhouse.session.six.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/base/person")
public class PersonBaseController {

    private final PersonRepository personRepository;

    public PersonBaseController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person findById(@PathVariable Integer id) {
        return this.personRepository.findById(id)
                .orElse(null);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        return this.personRepository.saveAndFlush(person);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Person update(@RequestBody Person person) {
        return this.personRepository.findById(person.getId())
                .map(element -> {
                    element.setAge(person.getAge());
                    element.setName(person.getName());
                    return this.personRepository.saveAndFlush(element);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.personRepository.deleteById(id);
    }
}
