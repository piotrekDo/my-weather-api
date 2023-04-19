package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class DailyUnits {
    private String time;
    private String temperature_2m_max;
    private String temperature_2m_min;
    private String sunrise;
    private String sunset;

    @Override
    public String toString() {
        return "DailyUnits{" +
                "time='" + time + '\'' +
                ", temperature_2m_max='" + temperature_2m_max + '\'' +
                ", temperature_2m_min='" + temperature_2m_min + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }
}
