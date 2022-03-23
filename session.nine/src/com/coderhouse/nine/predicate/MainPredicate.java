package com.coderhouse.nine.predicate;

import com.coderhouse.nine.base.CivilStatus;
import com.coderhouse.nine.base.Person;

import java.util.function.Predicate;

public class MainPredicate {

    public static void main(String[] args) {

        Person realPerson = new Person("carlos", 27, 30.0, false, CivilStatus.DIVORCED);

        Predicate<Person> function = person -> person.getName().length() > 0;
        System.out.println(function.test(realPerson));

        function = person -> CivilStatus.DIVORCED.equals(person.getCivilStatus());
        System.out.println(function.test(realPerson));

    }
}
