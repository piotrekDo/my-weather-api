package com.example.myweatherapi.open_meteo;

import com.example.myweatherapi.MyWeatherApiApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MyWeatherApiApplication.class})
class OpenMeteoServiceTest {

    @Autowired
    OpenMeteoService openMeteoService;

    @Test
    void get_dates_should_return_valid_url_for_entered_dates() {
        //given
        String start = "2023-04-01";
        String end = "2023-04-30";

        //when
        String result = openMeteoService.getDates(start, end);

        //then
        assertEquals("&start_date=2023-04-01&end_date=2023-04-30&timezone=Europe/Berlin", result);
    }

}