package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class DailyValuesDto {

    private double temperature_2m_max;
    private double temperature_2m_min;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;


    @Override
    public String toString() {
        return "DailyValuesDto{" +
                "temperature_2m_max=" + temperature_2m_max +
                ", temperature_2m_min=" + temperature_2m_min +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyValuesDto that = (DailyValuesDto) o;
        return Double.compare(that.temperature_2m_max, temperature_2m_max) == 0 && Double.compare(that.temperature_2m_min, temperature_2m_min) == 0 && Objects.equals(sunrise, that.sunrise) && Objects.equals(sunset, that.sunset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature_2m_max, temperature_2m_min, sunrise, sunset);
    }
}
