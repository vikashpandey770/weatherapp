package com.example.weatherapp.service;

import com.example.weatherapp.client.WeatherApiClient;
import com.example.weatherapp.dto.GeocodingResponse;
import com.example.weatherapp.dto.WeatherApiResponse;
import com.example.weatherapp.dto.WeatherResponse;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherApiClient weatherApiClient;

    public WeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public WeatherResponse getCurrentWeather(String city) {

        // Step 1: City ki location find karo
        GeocodingResponse.Location location =
                weatherApiClient.getLocation(city);

        // Step 2: Location ke coordinates se weather fetch karo
        WeatherApiResponse weatherData =
                weatherApiClient.getWeather(
                        location.getLatitude(),
                        location.getLongitude()
                );

        if (weatherData == null || weatherData.getCurrent() == null) {
            throw new RuntimeException("Weather data is not available");
        }

        WeatherApiResponse.Current current = weatherData.getCurrent();

        // Step 3: API data ko WeatherResponse mein set karo
        WeatherResponse response = new WeatherResponse();

        response.setCity(location.getName());
        response.setCountry(location.getCountry());
        response.setTime(current.getTime());
        response.setTemperature(current.getTemperature2m());
        response.setFeelsLike(current.getApparentTemperature());
        response.setHumidity(current.getRelativeHumidity2m());
        response.setPrecipitation(current.getPrecipitation());
        response.setCondition(
                getWeatherCondition(current.getWeatherCode())
        );
        response.setWindSpeed(current.getWindSpeed10m());
        response.setWindDirection(current.getWindDirection10m());

        response.setDayStatus(
                current.getIsDay() != null && current.getIsDay() == 1
                        ? "Day"
                        : "Night"
        );

        return response;
    }

    // Weather code ko readable condition mein convert karna
    private String getWeatherCondition(Integer code) {

        if (code == null) {
            return "Unknown";
        }

        return switch (code) {
            case 0 -> "Clear Sky";
            case 1 -> "Mainly Clear";
            case 2 -> "Partly Cloudy";
            case 3 -> "Overcast";
            case 45, 48 -> "Fog";
            case 51, 53, 55 -> "Drizzle";
            case 56, 57 -> "Freezing Drizzle";
            case 61, 63, 65 -> "Rain";
            case 66, 67 -> "Freezing Rain";
            case 71, 73, 75 -> "Snowfall";
            case 77 -> "Snow Grains";
            case 80, 81, 82 -> "Rain Showers";
            case 85, 86 -> "Snow Showers";
            case 95 -> "Thunderstorm";
            case 96, 99 -> "Thunderstorm with Hail";
            default -> "Unknown Weather";
        };
    }
}
