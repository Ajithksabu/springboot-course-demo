package com.springboot.demo.exceptions;

public class EmployeeBranchNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmployeeBranchNotFoundException(String message) {
        super(message);
    }

}
