package com.example.myweatherapi.open_meteo;

import com.example.myweatherapi.MyWeatherApiApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MyWeatherApiApplication.class})
class OpenMeteoUrlBuilderTest {

    @Autowired
    OpenMeteoUrlBuilder openMeteoUrlBuilder;

    @Test
    void get_full_forecast_url_should_return_valid_url_for_entered_values() {
        //given
        double lat = 52.52;
        double lon = 13.41;
        String start = "2023-04-01";
        String end = "2023-04-03";

        //when
        String result = openMeteoUrlBuilder.getFullForecastUrl(lat, lon, start, end);

        //then
        assertEquals("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true&hourly=temperature_2m,rain,snowfall,weathercode,surface_pressure,visibility,windspeed_10m,winddirection_10m&daily=temperature_2m_max,temperature_2m_min,sunrise,sunset&start_date=2023-04-01&end_date=2023-04-03&timezone=Europe/Berlin",
                result);
    }

    @Test
    void get_current_weather_url_should_return_valid_url() {
        //given
        double lat = 52.52;
        double lon = 13.41;

        //when
        String result = openMeteoUrlBuilder.getCurrentWeatherUrl(lat, lon);

        //then
        assertEquals("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true",
                result);
    }

    @Test
    void get_full_forecast_test() {
        //given
        double lat = 52.52;
        double lon = 13.41;
        String start = "2023-04-01";
        String end = "2023-04-03";
        String url = openMeteoUrlBuilder.getFullForecastUrl(lat, lon, start, end);
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        OpenMeteoResponseModel forObject = restTemplate.getForObject(url, OpenMeteoResponseModel.class);
        System.out.println(forObject);
    }

    @Test
    void get_current_waather_test() {
        //given
        double lat = 52.52;
        double lon = 13.41;
        String url = openMeteoUrlBuilder.getCurrentWeatherUrl(lat, lon);
        RestTemplate restTemplate = new RestTemplate();
        OpenMeteoResponseModel forObject = restTemplate.getForObject(url, OpenMeteoResponseModel.class);
        System.out.println(forObject);
    }

}