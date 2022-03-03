package com.coderhouse.session.three;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Integer id) {
        super(String.format("Employee with %d was not foud", id));
    }
}
