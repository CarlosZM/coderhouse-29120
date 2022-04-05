package com.coderhouse.session.ten.controllers;

import com.coderhouse.session.ten.domain.Person;

public class PersonTokenCarrier {

    private Person person;

    private RegisterStep step;

    public PersonTokenCarrier(Person person, RegisterStep step) {
        this.person = person;
        this.step = step;
    }

    public PersonTokenCarrier() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public RegisterStep getStep() {
        return step;
    }

    public void setStep(RegisterStep step) {
        this.step = step;
    }
}
