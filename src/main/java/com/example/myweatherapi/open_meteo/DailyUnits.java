package com.example.myweatherapi.open_meteo;

 class DailyUnits {
    private String time;
    private String temperature_2m_max;
    private String temperature_2m_min;
    private String sunrise;
    private String sunset;

     DailyUnits() {
    }

     @Override
     public String toString() {
         return "DailyUnits{" +
                 "time='" + time + '\'' +
                 ", temperature_2m_max='" + temperature_2m_max + '\'' +
                 ", temperature_2m_min='" + temperature_2m_min + '\'' +
                 ", sunrise='" + sunrise + '\'' +
                 ", sunset='" + sunset + '\'' +
                 '}';
     }

     public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(String temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public String getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(String temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
}
