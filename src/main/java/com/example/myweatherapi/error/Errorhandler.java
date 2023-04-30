package com.example.myweatherapi.error;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class Errorhandler {

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<ErrorEntity<String>> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>(new ErrorEntity<>(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(CityNotFoundException.class)
    ResponseEntity<ErrorEntity<String>> handleNoSuchCity(CityNotFoundException e) {
        return new ResponseEntity<>(new ErrorEntity<>(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = IllegalOperationException.class)
    ResponseEntity<ErrorEntity<String>> handleIllegalOperationException(IllegalOperationException e) {
        return new ResponseEntity<>(new ErrorEntity<>(HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    ResponseEntity<ErrorEntity<String>> handleExpiredJwtException(ExpiredJwtException e) {
        return new ResponseEntity<>(new ErrorEntity<>(
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN.getReasonPhrase(),
                e.getMessage()), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResourceForbiddenException.class)
    ResponseEntity<ErrorEntity<String>> handleResourceForbiddenException(ResourceForbiddenException e) {
        return new ResponseEntity<>(new ErrorEntity<>(
                HttpStatus.FORBIDDEN.value(),
                HttpStatus.FORBIDDEN.getReasonPhrase(),
                e.getMessage()), HttpStatus.NOT_FOUND
        );
    }

}
