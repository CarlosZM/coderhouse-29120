package com.coderhouse.session.eleven.employee;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class EmployeeEntity {

    private Integer id;

    @Size(min = 3, max = 50)
    private String firstName;

    private String lastName;

    private LocalDateTime birthDate;

    public EmployeeEntity(Integer id, String firstName, String lastName, LocalDateTime birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public EmployeeEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
