package com.example.myweatherapi.open_meteo;

import org.springframework.stereotype.Service;

@Service
public class OpenMeteoService {

    final String baseUrl = "https://api.open-meteo.com/v1/forecast?";

    String setLocalization(Double lat, Double lon) {
        String latValue = lat.toString().replace(",", ".");
        String lonValue = lon.toString().replace(",", ".");
        return String.format("latitude=%s&longitude=%s&current_weather=true", latValue, lonValue);
    }

    String getHourlyForecastUrl(boolean temperature, boolean rain, boolean snowfall, boolean weathercode, boolean pressure, boolean visibility, boolean windSpeed, boolean windDirection) {
        String base = "&hourly=";
        if (temperature) base += "temperature_2m,";
        if (rain) base += "rain,";
        if (snowfall) base += "snowfall,";
        if (weathercode) base += "weathercode,";
        if (pressure) base += "surface_pressure,";
        if (visibility) base += "visibility,";
        if (windSpeed) base += "windspeed_10m,";
        if (windDirection) base += "winddirection_10m,";

        return base.substring(0, base.length() - 1);
    }

    String getDailyWeatherUrl(boolean temperatureMax, boolean temperatureMin, boolean sunrise, boolean sunset) {
        ;
        String base = "&daily=";
        if (temperatureMax) base += "temperature_2m_max,";
        if (temperatureMin) base += "temperature_2m_min,";
        if (sunrise) base += "sunrise,";
        if (sunset) base += "sunset,";

        return base.substring(0, base.length() - 1);
    }

    String getDates(String start, String end) {
        return String.format("&start_date=%s&end_date=%s&timezone=Europe/Berlin", start, end);
    }

}
