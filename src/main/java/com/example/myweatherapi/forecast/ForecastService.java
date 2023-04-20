package com.example.myweatherapi.forecast;

import com.example.myweatherapi.error.CityNotFoundException;
import com.example.myweatherapi.geocode.GeoModel;
import com.example.myweatherapi.geocode.GeoService;
import com.example.myweatherapi.open_meteo.OpenMeteoResponseDto;
import com.example.myweatherapi.open_meteo.OpenMeteoResponseModel;
import com.example.myweatherapi.open_meteo.OpenMeteoService;
import com.example.myweatherapi.open_meteo.OpenMeteoUrlBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ForecastService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final GeoService geoService;
    private final OpenMeteoService openMeteoService;
    private final OpenMeteoUrlBuilder openMeteoUrlBuilder;

    public ForecastService(GeoService geoService, OpenMeteoService openMeteoService, OpenMeteoUrlBuilder openMeteoUrlBuilder) {
        this.geoService = geoService;
        this.openMeteoService = openMeteoService;
        this.openMeteoUrlBuilder = openMeteoUrlBuilder;
    }

    GeoModel getCoordinatesByCityName(String city) {
        String url = geoService.getUrlByCityName(city);
        GeoModel geoModel;

        try{
            geoModel = restTemplate.getForObject(url, GeoModel[].class)[0];
        }catch (Exception e) {
            throw new CityNotFoundException("No such city or address");
        }

        return geoModel;
    }

    OpenMeteoResponseDto getForecast(Double lat, Double lon, String start, String end) {
        String fullForecastUrl = openMeteoUrlBuilder.getFullForecastUrl(lat, lon, start, end);
        return restTemplate.getForObject(fullForecastUrl, OpenMeteoResponseDto.class);
    }

    OpenMeteoResponseDto getForecast(String city, String start, String end) {
        GeoModel geo = getCoordinatesByCityName(city);
        double lat = Double.parseDouble(geo.getLat());
        double lon = Double.parseDouble(geo.getLon());
        String fullForecastUrl = openMeteoUrlBuilder.getFullForecastUrl(lat, lon, start, end);
        OpenMeteoResponseModel response = restTemplate.getForObject(fullForecastUrl, OpenMeteoResponseModel.class);
        return OpenMeteoResponseDto.mapOpenMeteoResponseToDto(response, geo.getDisplay_name());
    }

}
