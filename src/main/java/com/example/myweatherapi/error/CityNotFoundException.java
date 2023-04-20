package com.example.myweatherapi.error;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(String message) {
        super(message);
    }
}
