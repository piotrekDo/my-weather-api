package com.example.myweatherapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Errorhandler {

    @ExceptionHandler(CityNotFoundException.class)
    ResponseEntity<ErrorEntity<String>> handleNoSuchCity(CityNotFoundException e) {
        return new ResponseEntity<>(new ErrorEntity<>(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage()), HttpStatus.NOT_FOUND
        );
    }
}
