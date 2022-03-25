package com.springboot.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {

    @ExceptionHandler(EmployeeBranchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorDetails handleBranchNameNotFoundException(EmployeeBranchNotFoundException ex) {
        return new CustomErrorDetails(new Date(), "Not found", ex.getMessage());
    }
}
