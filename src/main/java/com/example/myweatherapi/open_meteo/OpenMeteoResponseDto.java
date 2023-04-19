package com.example.myweatherapi.open_meteo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class OpenMeteoResponseDto {
    private double latitude;
    private double longitude;
    private String timezone;
    private CurrentWeather current_weather;
    private HourlyUnits hourly_units;
    private HourlyDto hourly;
    private DailyUnits daily_units;
    private DailyDto daily;

    public static OpenMeteoResponseDto mapOpenMeteoResponseToDto(OpenMeteoResponseModel model) {
        return new OpenMeteoResponseDto(
                model.getLatitude(),
                model.getLongitude(),
                model.getTimezone(),
                model.getCurrent_weather(),
                model.getHourly_units(),
                HourlyDto.mapHourlyToDto(model.getHourly()),
                model.getDaily_units(),
                DailyDto.mapDailyToDto(model.getDaily())
        );
    }

    @Override
    public String toString() {
        return "OpenMeteoResponseDto{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezone='" + timezone + '\'' +
                ", current_weather=" + current_weather +
                ", hourly_units=" + hourly_units +
                ", hourly=" + hourly +
                ", daily_units=" + daily_units +
                ", daily=" + daily +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenMeteoResponseDto that = (OpenMeteoResponseDto) o;
        return Double.compare(that.latitude, latitude) == 0 && Double.compare(that.longitude, longitude) == 0 && Objects.equals(timezone, that.timezone) && Objects.equals(current_weather, that.current_weather) && Objects.equals(hourly_units, that.hourly_units) && Objects.equals(hourly, that.hourly) && Objects.equals(daily_units, that.daily_units) && Objects.equals(daily, that.daily);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, timezone, current_weather, hourly_units, hourly, daily_units, daily);
    }
}
