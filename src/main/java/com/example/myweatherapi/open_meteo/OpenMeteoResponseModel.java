package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OpenMeteoResponseModel {
    private double latitude;
    private double longitude;
    private String timezone;
    private CurrentWeather current_weather;
    private HourlyUnits hourly_units;
    private Hourly hourly;
    private DailyUnits daily_units;
    private Daily daily;

    @Override
    public String toString() {
        return "OpenMeteoResponseModel{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                ", current_weather=" + current_weather +
                ", hourly_units=" + hourly_units +
                ", hourly=" + hourly +
                ", daily_units=" + daily_units +
                ", daily=" + daily +
                '}';
    }

}
