package com.zuzex.exceptions.model;

import java.time.LocalDateTime;

public class BadTokenException extends RuntimeException {

    private LocalDateTime dateTime;
    private String message;

    public BadTokenException(String message) {
        dateTime = LocalDateTime.now();
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
