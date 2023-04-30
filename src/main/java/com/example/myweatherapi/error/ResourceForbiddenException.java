package com.example.myweatherapi.error;

public class ResourceForbiddenException extends RuntimeException{
    public ResourceForbiddenException(String message) {
        super(message);
    }
}
