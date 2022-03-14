package com.coderhouse.session.six;

import com.coderhouse.session.six.base.Person;
import com.coderhouse.session.six.base.PersonRepository;
import com.coderhouse.session.six.exceptions.SQLException;
import org.springframework.stereotype.Service;

import javax.transaction.InvalidTransactionException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(rollbackOn = SQLException.class)
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

    @Transactional(rollbackOn = InvalidTransactionException.class)
    public List<Person> saveListWithOtherTransaction(List<Person> list) throws SQLException {
        return this.saveListWithoutTransaction(list);
    }

    @Transactional(rollbackOn = SQLException.class, value = Transactional.TxType.REQUIRES_NEW)
    public List<Person> saveFirst(List<Person> list) throws SQLException {
        List<Person> persisted = this.saveWithANewCommit(list);
        this.personRepository.saveAndFlush(list.get(0));
        throw new SQLException("Save first exception launch");
    }

    @Transactional(rollbackOn = SQLException.class)
    public List<Person> saveWithANewCommit(List<Person> list) throws SQLException {
        return this.saveListWithoutTransaction(list);
    }

    @Transactional(rollbackOn = SQLException.class)
    public List<Person> saveFirstOneCommit(List<Person> list) throws SQLException {
        this.personRepository.saveAndFlush(list.get(0));
        return this.saveListWithoutTransaction(list);
    }
}
