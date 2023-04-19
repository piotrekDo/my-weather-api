package com.example.myweatherapi.forecast;

import com.example.myweatherapi.open_meteo.OpenMeteoResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forecast")
public class ForecastController {

    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping
    OpenMeteoResponseDto getForecastByCityName(@RequestParam String city,
                                               @RequestParam String start,
                                               @RequestParam String end) {
        return forecastService.getForecast(city, start, end);
    }
}
