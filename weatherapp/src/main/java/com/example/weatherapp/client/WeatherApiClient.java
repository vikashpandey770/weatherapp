package com.example.weatherapp.client;

import com.example.weatherapp.dto.GeocodingResponse;
import com.example.weatherapp.dto.WeatherApiResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class WeatherApiClient {
    private final RestClient restClient;
    public WeatherApiClient(RestClient restClient) {
        this.restClient = restClient;
    }
    // Step 1: City name se location find karna
    public GeocodingResponse.Location getLocation(String city) {

        GeocodingResponse response = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("geocoding-api.open-meteo.com")
                        .path("/v1/search")
                        .queryParam("name", city)
                        .queryParam("count", 1)
                        .queryParam("language", "en")
                        .queryParam("format", "json")
                        .build())
                .retrieve()
                .body(GeocodingResponse.class);

        if (response == null
                || response.getResults() == null
                || response.getResults().isEmpty()) {

            throw new RuntimeException(
                    "City not found: " + city);
        }

        return response.getResults().get(0);
    }

    // Step 2: Latitude aur longitude se weather fetch karna
 // Step 2: Latitude aur longitude se weather fetch karna
    public WeatherApiResponse getWeather(
            double latitude,
            double longitude) {

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api.open-meteo.com")
                        .path("/v1/forecast")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .queryParam(
                                "current",
                                "temperature_2m,"
                                + "relative_humidity_2m,"
                                + "apparent_temperature,"
                                + "is_day,"
                                + "precipitation,"
                                + "weather_code,"
                                + "wind_speed_10m,"
                                + "wind_direction_10m")
                        .queryParam("timezone", "auto")
                        .build())
                .retrieve()
                .body(WeatherApiResponse.class);
    }
    
    
}