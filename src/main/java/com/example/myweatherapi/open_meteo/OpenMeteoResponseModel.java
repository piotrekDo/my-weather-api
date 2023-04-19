package com.example.myweatherapi.open_meteo;

public class OpenMeteoResponseModel {
    private double latitude;
    private double longitude;
    private String timezone;
    private CurrentWeather current_weather;
    private HourlyUnits hourly_units;
    private Hourly hourly;
    private DailyUnits daily_units;
    private Daily daily;

   public OpenMeteoResponseModel() {
    }

    @Override
    public String toString() {
        return "OpenMeteoResponseModel{" +
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public CurrentWeather getCurrent_weather() {
        return current_weather;
    }

    public void setCurrent_weather(CurrentWeather current_weather) {
        this.current_weather = current_weather;
    }

    public HourlyUnits getHourly_units() {
        return hourly_units;
    }

    public void setHourly_units(HourlyUnits hourly_units) {
        this.hourly_units = hourly_units;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public DailyUnits getDaily_units() {
        return daily_units;
    }

    public void setDaily_units(DailyUnits daily_units) {
        this.daily_units = daily_units;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }
}
