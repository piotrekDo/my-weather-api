package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class HourlyUnits {
    private String time;
    private String temperature_2m;
    private String rain;
    private String snowfall;
    private String weathercode;
    private String surface_pressure;
    private String visibility;
    private String windspeed_10m;
    private String winddirection_10m;

    @Override
    public String toString() {
        return "HourlyUnits{" +
                "time='" + time + '\'' +
                ", temperature_2m='" + temperature_2m + '\'' +
                ", rain='" + rain + '\'' +
                ", snowfall='" + snowfall + '\'' +
                ", weathercode='" + weathercode + '\'' +
                ", surface_pressure='" + surface_pressure + '\'' +
                ", visibility='" + visibility + '\'' +
                ", windspeed_10m='" + windspeed_10m + '\'' +
                ", winddirection_10m='" + winddirection_10m + '\'' +
                '}';
    }
}
