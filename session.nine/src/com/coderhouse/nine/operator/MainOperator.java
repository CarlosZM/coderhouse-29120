package com.coderhouse.nine.operator;

import com.coderhouse.nine.base.CivilStatus;
import com.coderhouse.nine.base.Person;

import java.util.function.BinaryOperator;

public class MainOperator {

    public static void main(String[] args) {

        Person realPerson = new Person("carlos", 27, 30.0, false, CivilStatus.DIVORCED);
        Person realPerson2 = new Person("pepito", 30, 80.0, true, CivilStatus.SINGLE);

        BinaryOperator<Person> function = (person1, person2) -> new Person(person1.getName(), person2.getAge(), person1.getSalary(), person2.getWorking(), person1.getCivilStatus());
        System.out.println(realPerson);
        System.out.println(realPerson2);
        System.out.println(function.apply(realPerson, realPerson2));

    }
}
