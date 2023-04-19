package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class CurrentWeather {
    private double temperature;
    private double windspeed;
    private int winddirection;
    private int weathercode;
    private String time;

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "temperature=" + temperature +
                ", windspeed=" + windspeed +
                ", winddirection=" + winddirection +
                ", weathercode=" + weathercode +
                ", time='" + time + '\'' +
                '}';
    }

}
