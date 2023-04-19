package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class HourlyValuesDto {
    private double temperature_2m;
    private double rain;
    private double snowfall;
    private int weathercode;
    private double surface_pressure;
    private int visibility;
    private double windspeed_10m;
    private int winddirection_10m;

    @Override
    public String toString() {
        return "HourlyValuesDto{" +
                "temperature_2m=" + temperature_2m +
                ", rain=" + rain +
                ", snowfall=" + snowfall +
                ", weathercode=" + weathercode +
                ", surface_pressure=" + surface_pressure +
                ", visibility=" + visibility +
                ", windspeed_10m=" + windspeed_10m +
                ", winddirection_10m=" + winddirection_10m +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HourlyValuesDto that = (HourlyValuesDto) o;
        return Double.compare(that.temperature_2m, temperature_2m) == 0 && Double.compare(that.rain, rain) == 0 && Double.compare(that.snowfall, snowfall) == 0 && weathercode == that.weathercode && Double.compare(that.surface_pressure, surface_pressure) == 0 && visibility == that.visibility && Double.compare(that.windspeed_10m, windspeed_10m) == 0 && winddirection_10m == that.winddirection_10m;
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature_2m, rain, snowfall, weathercode, surface_pressure, visibility, windspeed_10m, winddirection_10m);
    }
}


