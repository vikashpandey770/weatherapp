package com.example.weatherapp.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherApiResponse {

private Current current;

public Current getCurrent() {
    return current;
}

public void setCurrent(Current current) {
    this.current = current;
}

public static class Current {

    private String time;

    @JsonProperty("temperature_2m")
    private Double temperature2m;

    @JsonProperty("relative_humidity_2m")
    private Integer relativeHumidity2m;

    @JsonProperty("apparent_temperature")
    private Double apparentTemperature;

    @JsonProperty("is_day")
    private Integer isDay;

    private Double precipitation;

    @JsonProperty("weather_code")
    private Integer weatherCode;

    @JsonProperty("wind_speed_10m")
    private Double windSpeed10m;

    @JsonProperty("wind_direction_10m")
    private Integer windDirection10m;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTemperature2m() {
        return temperature2m;
    }

    public void setTemperature2m(Double temperature2m) {
        this.temperature2m = temperature2m;
    }

    public Integer getRelativeHumidity2m() {
        return relativeHumidity2m;
    }

    public void setRelativeHumidity2m(Integer relativeHumidity2m) {
        this.relativeHumidity2m = relativeHumidity2m;
    }

    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public Integer getIsDay() {
        return isDay;
    }

    public void setIsDay(Integer isDay) {
        this.isDay = isDay;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public Integer getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
    }

    public Double getWindSpeed10m() {
        return windSpeed10m;
    }

    public void setWindSpeed10m(Double windSpeed10m) {
        this.windSpeed10m = windSpeed10m;
    }

    public Integer getWindDirection10m() {
        return windDirection10m;
    }

    public void setWindDirection10m(Integer windDirection10m) {
        this.windDirection10m = windDirection10m;
    }
}


}
