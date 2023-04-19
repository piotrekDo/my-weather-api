package com.example.myweatherapi.open_meteo;

import java.util.Arrays;

class Hourly {
    private String[] time;
    private double[] temperature_2m;
    private double[] rain;
    private double[] snowfall;
    private int[] weathercode;
    private double[] surface_pressure;
    private int[] visibility;
    private double[] windspeed_10m;
    private int[] winddirection_10m;

     Hourly() {
    }

    @Override
    public String toString() {
        return "Hourly{" +
                "time=" + Arrays.toString(time) +
                ", temperature_2m=" + Arrays.toString(temperature_2m) +
                ", rain=" + Arrays.toString(rain) +
                ", snowfall=" + Arrays.toString(snowfall) +
                ", weathercode=" + Arrays.toString(weathercode) +
                ", surface_pressure=" + Arrays.toString(surface_pressure) +
                ", visibility=" + Arrays.toString(visibility) +
                ", windspeed_10m=" + Arrays.toString(windspeed_10m) +
                ", winddirection_10m=" + Arrays.toString(winddirection_10m) +
                '}';
    }

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    public double[] getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(double[] temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public double[] getRain() {
        return rain;
    }

    public void setRain(double[] rain) {
        this.rain = rain;
    }

    public double[] getSnowfall() {
        return snowfall;
    }

    public void setSnowfall(double[] snowfall) {
        this.snowfall = snowfall;
    }

    public int[] getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(int[] weathercode) {
        this.weathercode = weathercode;
    }

    public double[] getSurface_pressure() {
        return surface_pressure;
    }

    public void setSurface_pressure(double[] surface_pressure) {
        this.surface_pressure = surface_pressure;
    }

    public int[] getVisibility() {
        return visibility;
    }

    public void setVisibility(int[] visibility) {
        this.visibility = visibility;
    }

    public double[] getWindspeed_10m() {
        return windspeed_10m;
    }

    public void setWindspeed_10m(double[] windspeed_10m) {
        this.windspeed_10m = windspeed_10m;
    }

    public int[] getWinddirection_10m() {
        return winddirection_10m;
    }

    public void setWinddirection_10m(int[] winddirection_10m) {
        this.winddirection_10m = winddirection_10m;
    }
}
