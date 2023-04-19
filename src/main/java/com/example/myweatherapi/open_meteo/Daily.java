package com.example.myweatherapi.open_meteo;

import java.util.Arrays;

class Daily {
    private String[] time;
    private double[] temperature_2m_max;
    private double[] temperature_2m_min;
    private String[] sunrise;
    private String[] sunset;

     Daily() {
    }

    @Override
    public String toString() {
        return "Daily{" +
                "time=" + Arrays.toString(time) +
                ", temperature_2m_max=" + Arrays.toString(temperature_2m_max) +
                ", temperature_2m_min=" + Arrays.toString(temperature_2m_min) +
                ", sunrise=" + Arrays.toString(sunrise) +
                ", sunset=" + Arrays.toString(sunset) +
                '}';
    }

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    public double[] getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(double[] temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public double[] getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(double[] temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public String[] getSunrise() {
        return sunrise;
    }

    public void setSunrise(String[] sunrise) {
        this.sunrise = sunrise;
    }

    public String[] getSunset() {
        return sunset;
    }

    public void setSunset(String[] sunset) {
        this.sunset = sunset;
    }
}
