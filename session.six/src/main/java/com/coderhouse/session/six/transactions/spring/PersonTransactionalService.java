package com.coderhouse.session.six.transactions.spring;

import com.coderhouse.session.six.base.Person;
import com.coderhouse.session.six.base.PersonRepository;
import com.coderhouse.session.six.exceptions.SQLException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class PersonTransactionalService {

    private final PersonRepository personRepository;

    public PersonTransactionalService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(rollbackFor = SQLException.class)
    public List<Person> saveList(List<Person> list) throws SQLException {
        return this.saveListWithoutTransaction(list);
    }

    public List<Person> saveListWithoutTransaction(List<Person> list) throws SQLException {
        List<Person> response = this.personRepository.saveAllAndFlush(
                list
        );

        if (list.size() % 5 == 0) {
            throw new SQLException("Custom exception for endpoint /base/person/exception");
        }

        return response;
    }

    @Transactional(rollbackFor = SQLException.class, propagation = REQUIRES_NEW, label = "saveListWithCommits")
    public List<Person> saveListWithCommits(List<Person> list) throws SQLException {
        this.saveListWithoutTransaction(list);
        this.saveListWithoutTransaction(list);
        throw new SQLException("ERROR");
    }
}
