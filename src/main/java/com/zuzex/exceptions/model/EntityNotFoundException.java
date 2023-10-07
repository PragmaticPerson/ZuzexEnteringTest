package com.zuzex.exceptions.model;

import java.time.LocalDateTime;

public class EntityNotFoundException extends RuntimeException {

    private LocalDateTime dateTime;
    private String message;

    public EntityNotFoundException(int id) {
        dateTime = LocalDateTime.now();
        this.message = String.format("Can't find entity with id %d", id);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
