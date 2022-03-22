package com.springboot.demo.exceptions;

public class UserNotFoundException extends Exception {

    //Serial version uid
    private static final long serialVersionUID = 1L;

    //constructor using super class
    public UserNotFoundException(String message) {
        super(message);
    }

}
