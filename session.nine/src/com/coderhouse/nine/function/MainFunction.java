package com.coderhouse.nine.function;

import com.coderhouse.nine.base.CivilStatus;
import com.coderhouse.nine.base.Person;

import java.util.function.Function;

public class MainFunction {

    public static void main(String[] args) {

        Person realPerson = new Person("carlos", 27, 30.0, false, CivilStatus.DIVORCED);

        Function<Person, String> function = Person::getName;
        System.out.println(function.apply(realPerson));

        function = person -> person.getName() + person.getCivilStatus().name();
        System.out.println(function.apply(realPerson));

    }
}
