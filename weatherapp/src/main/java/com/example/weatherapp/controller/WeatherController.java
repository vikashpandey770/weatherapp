
package com.example.weatherapp.controller;

import com.example.weatherapp.dto.WeatherResponse;
import com.example.weatherapp.service.WeatherService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // Current weather API
    @GetMapping("/current")
    public WeatherResponse getCurrentWeather(
            @RequestParam String city) {

        return weatherService.getCurrentWeather(city);
    }
}

