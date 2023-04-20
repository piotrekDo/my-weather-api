package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class DailyValuesDto {
    private LocalDate time;
    private double temperature_2m_max;
    private double temperature_2m_min;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
}
