package com.coderhouse.session.six.transactions.java;

import com.coderhouse.session.six.base.Person;
import com.coderhouse.session.six.exceptions.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactional/person")
public class PersonSimpleTransactionController {

    private final PersonService personService;

    public PersonSimpleTransactionController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/with")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> exception(@RequestBody List<Person> list) throws SQLException {
        return this.personService.saveList(list);
    }

    @PostMapping("/without")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> exceptionWithoutTransaction(@RequestBody List<Person> list) throws SQLException {
        return this.personService.saveListWithoutTransaction(list);
    }

    @PostMapping("/other")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> exceptionWithOtherTransaction(@RequestBody List<Person> list) throws SQLException {
        return this.personService.saveListWithOtherTransaction(list);
    }

    @PostMapping("/nested-multiple-commit")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> exceptionWithMultipleCommit(@RequestBody List<Person> list) throws SQLException {
        return this.personService.saveFirst(list);
    }

    @PostMapping("/nested-one-commit")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> exceptionWithOneCommit(@RequestBody List<Person> list) throws SQLException {
        return this.personService.saveFirstOneCommit(list);
    }
}
