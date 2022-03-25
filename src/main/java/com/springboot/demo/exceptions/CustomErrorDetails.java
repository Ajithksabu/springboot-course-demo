package com.springboot.demo.exceptions;

import java.util.Date;

public class CustomErrorDetails {
    private Date timestamp;
    private String message;
    private String errorDetails;

    public CustomErrorDetails(Date timestamp, String message, String errorDetails) {
        this.timestamp = timestamp;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public String getErrorDetails() {
        return this.errorDetails;
    }

}
