package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class DailyDto {

    private LocalDate start;
    private LocalDate end;
    private Map<LocalDate, DailyValuesDto> hourly;

    public static DailyDto mapDailyToDto(Daily daily) {
        Map<LocalDate, DailyValuesDto> values = new LinkedHashMap<>();
        for (int i = 0; i < daily.getTime().length; i++) {
            values.put(
                    LocalDate.parse(daily.getTime()[i]),
                    new DailyValuesDto(
                            daily.getTemperature_2m_max()[i],
                            daily.getTemperature_2m_min()[i],
                            LocalDateTime.parse(daily.getSunrise()[i]),
                            LocalDateTime.parse(daily.getSunset()[i])
                    ));
        }
        LocalDate start = values.keySet().stream().min(LocalDate::compareTo).orElse(null);
        LocalDate end = values.keySet().stream().max(LocalDate::compareTo).orElse(null);
        return new DailyDto(start, end, values);
    }
}
