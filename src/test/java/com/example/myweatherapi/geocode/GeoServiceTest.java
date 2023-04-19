package com.example.myweatherapi.geocode;

import com.example.myweatherapi.MyWeatherApiApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MyWeatherApiApplication.class})
class GeoServiceTest {

    @Autowired
    GeoService geoService;

    @ParameterizedTest
    @CsvSource(value = {"New York;New+York", "Berlin;Berlin"}, delimiter = ';')
    void get_url_by_city_name_should_return_valid_url(String city, String expected) {
        //when
        String result = geoService.getUrlByCityName(city);

        //then
        System.out.println("https://geocode.maps.co/search?city=" + expected);
        assertEquals("https://geocode.maps.co/search?city=" + expected, result);
    }
}