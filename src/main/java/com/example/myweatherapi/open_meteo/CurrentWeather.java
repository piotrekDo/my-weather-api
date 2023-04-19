package com.example.myweatherapi.open_meteo;

class CurrentWeather {
    private double temperature;
    private double windspeed;
    private int winddirection;
    private int weathercode;
    private String time;

    CurrentWeather() {
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "temperature=" + temperature +
                ", windspeed=" + windspeed +
                ", winddirection=" + winddirection +
                ", weathercode=" + weathercode +
                ", time='" + time + '\'' +
                '}';
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(double windspeed) {
        this.windspeed = windspeed;
    }

    public int getWinddirection() {
        return winddirection;
    }

    public void setWinddirection(int winddirection) {
        this.winddirection = winddirection;
    }

    public int getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(int weathercode) {
        this.weathercode = weathercode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
