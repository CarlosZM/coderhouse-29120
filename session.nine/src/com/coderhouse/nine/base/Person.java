package com.coderhouse.nine.base;

public class Person {

    private String name;

    private Integer age;

    private Double salary;

    private Boolean isWorking;

    private CivilStatus civilStatus;

    public Person(String name, Integer age, Double salary, Boolean isWorking, CivilStatus civilStatus) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.isWorking = isWorking;
        this.civilStatus = civilStatus;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", isWorking=" + isWorking +
                ", civilStatus=" + civilStatus +
                '}';
    }
}
