package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class HourlyDto {
    private LocalDateTime start;
    private LocalDateTime end;
    private List<HourlyValuesDto> values;

    public static HourlyDto mapHourlyToDto(Hourly hourly) {
        List<HourlyValuesDto> values = new LinkedList<>();

        for (int i = 0; i < hourly.getTime().length; i++) {
            values.add(
                    new HourlyValuesDto(
                            LocalDateTime.parse(hourly.getTime()[i]),
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

        LocalDateTime start = values.stream().map(HourlyValuesDto::getTime).min(LocalDateTime::compareTo).orElse(null);
        LocalDateTime end = values.stream().map(HourlyValuesDto::getTime).max(LocalDateTime::compareTo).orElse(null);
        return new HourlyDto(start, end, values);
    }


}
