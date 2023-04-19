package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class Hourly {
    private String[] time;
    private double[] temperature_2m;
    private double[] rain;
    private double[] snowfall;
    private int[] weathercode;
    private double[] surface_pressure;
    private int[] visibility;
    private double[] windspeed_10m;
    private int[] winddirection_10m;

    @Override
    public String toString() {
        return "Hourly{" +
                "time=" + Arrays.toString(time) +
                ", temperature_2m=" + Arrays.toString(temperature_2m) +
                ", rain=" + Arrays.toString(rain) +
                ", snowfall=" + Arrays.toString(snowfall) +
                ", weathercode=" + Arrays.toString(weathercode) +
                ", surface_pressure=" + Arrays.toString(surface_pressure) +
                ", visibility=" + Arrays.toString(visibility) +
                ", windspeed_10m=" + Arrays.toString(windspeed_10m) +
                ", winddirection_10m=" + Arrays.toString(winddirection_10m) +
                '}';
    }

}
