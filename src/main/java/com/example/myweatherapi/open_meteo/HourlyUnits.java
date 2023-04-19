package com.example.myweatherapi.open_meteo;

 class HourlyUnits {
    private String time;
    private String temperature_2m;
    private String rain;
    private String snowfall;
    private String weathercode;
    private String surface_pressure;
    private String visibility;
    private String windspeed_10m;
    private String winddirection_10m;

     HourlyUnits() {
    }

     @Override
     public String toString() {
         return "HourlyUnits{" +
                 "time='" + time + '\'' +
                 ", temperature_2m='" + temperature_2m + '\'' +
                 ", rain='" + rain + '\'' +
                 ", snowfall='" + snowfall + '\'' +
                 ", weathercode='" + weathercode + '\'' +
                 ", surface_pressure='" + surface_pressure + '\'' +
                 ", visibility='" + visibility + '\'' +
                 ", windspeed_10m='" + windspeed_10m + '\'' +
                 ", winddirection_10m='" + winddirection_10m + '\'' +
                 '}';
     }

     public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(String temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getSnowfall() {
        return snowfall;
    }

    public void setSnowfall(String snowfall) {
        this.snowfall = snowfall;
    }

    public String getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(String weathercode) {
        this.weathercode = weathercode;
    }

    public String getSurface_pressure() {
        return surface_pressure;
    }

    public void setSurface_pressure(String surface_pressure) {
        this.surface_pressure = surface_pressure;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWindspeed_10m() {
        return windspeed_10m;
    }

    public void setWindspeed_10m(String windspeed_10m) {
        this.windspeed_10m = windspeed_10m;
    }

    public String getWinddirection_10m() {
        return winddirection_10m;
    }

    public void setWinddirection_10m(String winddirection_10m) {
        this.winddirection_10m = winddirection_10m;
    }
}
