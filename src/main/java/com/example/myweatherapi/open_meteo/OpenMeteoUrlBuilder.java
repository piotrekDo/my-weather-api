package com.example.myweatherapi.open_meteo;

import org.springframework.stereotype.Service;

@Service
public class OpenMeteoUrlBuilder {

    private final OpenMeteoService openMeteoService;

    public OpenMeteoUrlBuilder(OpenMeteoService openMeteoService) {
        this.openMeteoService = openMeteoService;
    }

    public String getFullForecastUrl(Double lat, Double lon, String start, String end) {
        return openMeteoService.baseUrl +
                openMeteoService.setLocalization(lat, lon) +
                openMeteoService.getHourlyForecast(true, true, true, true, true, true, true, true) +
                openMeteoService.getDailyWeather(true, true, true, true) +
                openMeteoService.getDates(start, end);
    }

    public String getCurrentWeatherUrl(Double lat, Double lon) {
        return openMeteoService.baseUrl +
                openMeteoService.setLocalization(lat, lon);
    }
}
