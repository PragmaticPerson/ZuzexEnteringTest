package com.zuzex.exceptions.controller;

import com.zuzex.exceptions.model.BadTokenException;
import com.zuzex.exceptions.model.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<?> entityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex);
    }

    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<?> badCredentialsException(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler({BadTokenException.class})
    public ResponseEntity<?> badTokenException(BadTokenException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex);
    }
}
