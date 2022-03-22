package com.springboot.demo.exceptions;

public class UserAlreadyCreatedWithSameEmployeeCodeException extends Exception {
    private static final long serialVersionUID = 123L;

    public UserAlreadyCreatedWithSameEmployeeCodeException(String message) {
        super(message);
    }

}
