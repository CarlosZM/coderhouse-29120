package com.coderhouse.session.twelve.basic;

import java.time.LocalDateTime;
import java.util.Objects;

public class Person {

    @FieldSerialization(jsonKey = "first_name")
    private String firstName;

    @FieldSerialization(jsonKey = "last_name")
    private String lastName;

    @FieldIgnorable
    private String fullName;

    @FieldSerialization(jsonKey = "number_of_brothers")
    private Integer numberOfBrothers;

    @FieldSerialization(jsonKey = "birth_date")
    private LocalDateTime birthDate;

    @FieldIgnorable
    private Integer age;

    public Person() {
    }

    public Person(String firstName,
                  String lastName,
                  String fullName,
                  Integer numberOfBrothers,
                  LocalDateTime birthDate,
                  Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.numberOfBrothers = numberOfBrothers;
        this.birthDate = birthDate;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(fullName, person.fullName) && Objects.equals(numberOfBrothers, person.numberOfBrothers) && Objects.equals(birthDate, person.birthDate) && Objects.equals(age, person.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", numberOfBrothers=" + numberOfBrothers +
                ", birthDate=" + birthDate +
                ", age=" + age +
                '}';
    }

    @Initialization
    private void initData() {

        this.fullName = String.format("%s %s", this.firstName, this.lastName);

        this.age = LocalDateTime.now().getYear() - birthDate.getYear();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getNumberOfBrothers() {
        return numberOfBrothers;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Integer getAge() {
        return age;
    }
}
