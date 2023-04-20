package com.example.myweatherapi.open_meteo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DailyDtoTest {

    @Test
    void map_daily_to_dto_should_return_valid_dto_object() {
        //given
        Daily dailyModel = OpenMeteoResponseModelProvider.provideFullOpenMeteoResponseModel().getDaily();
        DailyValuesDto expectedDto = new DailyValuesDto( LocalDate.of(2023,04,02), 7.4, 1.9,
                LocalDateTime.of(2023, 04, 02, 06, 36),
                LocalDateTime.of(2023, 04, 02, 19, 43));
        //when
        DailyDto result = DailyDto.mapDailyToDto(dailyModel);

        //then
        assertEquals(expectedDto, result.getValues().get(1));
    }


}