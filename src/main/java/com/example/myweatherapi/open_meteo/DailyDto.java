package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class DailyDto {

    private LocalDate start;
    private LocalDate end;
    private List<DailyValuesDto> values;

    public static DailyDto mapDailyToDto(Daily daily) {
        List<DailyValuesDto> values = new LinkedList<>();
        for (int i = 0; i < daily.getTime().length; i++) {
            values.add(
                    new DailyValuesDto(
                            LocalDate.parse(daily.getTime()[i]),
                            daily.getTemperature_2m_max()[i],
                            daily.getTemperature_2m_min()[i],
                            LocalDateTime.parse(daily.getSunrise()[i]),
                            LocalDateTime.parse(daily.getSunset()[i])
                    ));
        }
        LocalDate start = values.stream().map(DailyValuesDto::getTime).min(LocalDate::compareTo).orElse(null);
        LocalDate end = values.stream().map(DailyValuesDto::getTime).max(LocalDate::compareTo).orElse(null);
        return new DailyDto(start, end, values);
    }
}
