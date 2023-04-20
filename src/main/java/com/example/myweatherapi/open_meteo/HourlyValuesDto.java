package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HourlyValuesDto {
    private LocalDateTime time;
    private double temperature_2m;
    private double rain;
    private double snowfall;
    private int weathercode;
    private double surface_pressure;
    private int visibility;
    private double windspeed_10m;
    private int winddirection_10m;

}


