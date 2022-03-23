package com.coderhouse.nine.supplier;

import java.util.function.Supplier;

public class FunctionFactory {

    private Supplier<String> firstName;

    private Supplier<String> lastName;

    public String concat() {
        return String.format("You'r firstName is %s, and last name is %s", firstName.get(), lastName.get());
    }

    public void setFirstName(Supplier<String> firstName) {
        this.firstName = firstName;
    }

    public void setLastName(Supplier<String> lastName) {
        this.lastName = lastName;
    }
}
