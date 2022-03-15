package com.coderhouse.session.six.transactions.spring;

import com.coderhouse.session.six.base.Person;
import com.coderhouse.session.six.exceptions.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactional/spring/person")
public class PersonSpringTransactionController {

    private final PersonTransactionalService personService;

    public PersonSpringTransactionController(PersonTransactionalService personService) {
        this.personService = personService;
    }

    @PostMapping("/with")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> exception(@RequestBody List<Person> list) throws SQLException {
        return this.personService.saveList(list);
    }

    @PostMapping("/with-commits")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> exceptionWithCommits(@RequestBody List<Person> list) throws SQLException {
        return this.personService.saveListWithCommits(list);
    }
}
