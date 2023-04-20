package com.example.myweatherapi.open_meteo;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class HourlyDtoTest {

    @Test
    void map_hourly_to_dto_should_return_valid_dto_object() {
        //given
        Hourly hourlyModel = OpenMeteoResponseModelProvider.provideFullOpenMeteoResponseModel().getHourly();
        HourlyValuesDto expectedValues = new HourlyValuesDto(LocalDateTime.of(2023,04,01,00,00),9.4, 0.2, 0, 61, 991.8, 18860, 5.4, 228);
        //when
        HourlyDto result = HourlyDto.mapHourlyToDto(hourlyModel);

        //then
        assertEquals(expectedValues, result.getValues().get(0));

    }
}