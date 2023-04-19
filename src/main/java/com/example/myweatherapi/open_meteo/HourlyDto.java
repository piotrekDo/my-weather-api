package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class HourlyDto {
    private LocalDateTime start;
    private LocalDateTime end;
    private Map<LocalDateTime, HourlyValuesDto> hourly;

    public static HourlyDto mapHourlyToDto(Hourly hourly) {
        Map<LocalDateTime, HourlyValuesDto> values = new LinkedHashMap<>();
        for (int i = 0; i < hourly.getTime().length; i++) {
            values.put(LocalDateTime.parse(hourly.getTime()[i]),
                    new HourlyValuesDto(
                            hourly.getTemperature_2m()[i],
                            hourly.getRain()[i],
                            hourly.getSnowfall()[i],
                            hourly.getWeathercode()[i],
                            hourly.getSurface_pressure()[i],
                            hourly.getVisibility()[i],
                            hourly.getWindspeed_10m()[i],
                            hourly.getWinddirection_10m()[i]
                    ));
        }
        LocalDateTime start = values.keySet().stream().min(LocalDateTime::compareTo).orElse(null);
        LocalDateTime end = values.keySet().stream().max(LocalDateTime::compareTo).orElse(null);
        return new HourlyDto(start, end, values);
    }

    @Override
    public String toString() {
        return "HourlyDto{" +
                "hourly=" + hourly +
                '}';
    }
}
