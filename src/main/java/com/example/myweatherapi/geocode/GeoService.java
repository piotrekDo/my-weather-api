package com.example.myweatherapi.geocode;

import org.springframework.stereotype.Service;

@Service
public class GeoService {
    private final String baseUrl = "https://geocode.maps.co/search?";

    public String getUrlByCityName(String city) {
        city = city.replace(" ", "+");
        return baseUrl + String.format("city=%s", city);
    }

    public String getUrlByPostalCode(String code) {
        return baseUrl + String.format("postalcode=%s", code);
    }
}

