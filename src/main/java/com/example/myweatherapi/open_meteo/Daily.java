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
class Daily {
    private String[] time;
    private double[] temperature_2m_max;
    private double[] temperature_2m_min;
    private String[] sunrise;
    private String[] sunset;

    @Override
    public String toString() {
        return "Daily{" +
                "time=" + Arrays.toString(time) +
                ", temperature_2m_max=" + Arrays.toString(temperature_2m_max) +
                ", temperature_2m_min=" + Arrays.toString(temperature_2m_min) +
                ", sunrise=" + Arrays.toString(sunrise) +
                ", sunset=" + Arrays.toString(sunset) +
                '}';
    }
}
