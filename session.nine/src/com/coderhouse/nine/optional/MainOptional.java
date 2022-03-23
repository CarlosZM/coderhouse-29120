package com.coderhouse.nine.optional;

import com.coderhouse.nine.base.CivilStatus;
import com.coderhouse.nine.base.Person;

import java.util.Optional;
import java.util.function.Function;

public class MainOptional {

    public static void main(String[] args) throws Exception {

        Person realPerson = new Person("carlos", 27, 30.0, false, CivilStatus.DIVORCED);

        Optional<Person> optionalPerson = Optional.of(realPerson);

        if (optionalPerson.isPresent()) {
            throw new Exception("IS PRESENT");
        }

        optionalPerson = Optional.empty();

        realPerson = optionalPerson
                .orElse(new Person());
    }

    private Person oldSchool() throws Exception {

        Person realPerson = null;

        //to check nulity
        if (realPerson != null) {
            throw new Exception("nulity");
        }
        return new Person();

    }
}
