package com.coderhouse.nine.stream;

import com.coderhouse.nine.base.CivilStatus;
import com.coderhouse.nine.base.Data;
import com.coderhouse.nine.base.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainStream {

    public static void main(String[] args) {

        Person realPerson = new Person("carlos", 40, 30.0, false, CivilStatus.DIVORCED);
        Person realPerson2 = new Person("pepito", 30, 80.0, true, CivilStatus.SINGLE);

        List<Person> personList = Arrays.asList(realPerson, realPerson2);

        System.out.println(personList.stream()
                .map(person -> new Data(person.getName(), person.getAge()))
                .collect(Collectors.toList()));

        System.out.println(personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList()));

        System.out.println(personList.stream()
                .filter(person -> person.getSalary() > 50.0)
                .collect(Collectors.toList()));

        System.out.println(personList.stream()
                .map(person -> new Data(person.getName(), person.getAge()))
                .filter(data -> data.getAge() > 20.0)
                .map(data -> new Person(data.getName(), data.getAge(), null, null, null))
                .filter(person -> person.getWorking() != null)
                .collect(Collectors.toList()));

        System.out.println(personList.stream()
                .collect(Collectors.toMap(Person::getName, Function.identity())));

        System.out.println(personList.stream()
                .map(Person::getName)
                .collect(Collectors.joining(",")));

        System.out.println(personList.stream()
                .mapToDouble(Person::getSalary)
                .sum());

        System.out.println(personList.stream()
                .mapToDouble(Person::getSalary)
                .max());

        System.out.println(personList.stream()
                .allMatch(person -> person.getSalary() > 90.0));

        System.out.println(personList.stream()
                .allMatch(person -> person.getName().length() > 4));

        System.out.println(personList.stream()
                .filter(person -> person.getSalary() > 50.0)
                .findFirst()
                .orElse(null));

        System.out.println(personList.stream()
                .filter(person -> person.getSalary() > 50.0)
                .findFirst()
                .orElse(null));

        System.out.println(personList.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList()));
    }
}
