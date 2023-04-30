package com.example.myweatherapi.error;

public class IllegalOperationException extends RuntimeException{
    public IllegalOperationException(String message) {
        super(message);
    }
}
