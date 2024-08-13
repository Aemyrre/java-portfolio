package com.example.weather_api.application;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {
    
    // @Value("${c842434959e93ea8f4d43fe86539a710}")
    private final String apiKey = "c842434959e93ea8f4d43fe86539a710";

    // @Value("${https://api.openweathermap.org/data/2.5}")
    private final String apiUrlForLatAndLon = "https://api.openweathermap.org/data/2.5";

    private final String apiUrlForCity = "http://api.openweathermap.org/geo/1.0";

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApiUrlForLatAndLon() {
        return this.apiUrlForLatAndLon;
    }

    public String getApirUrlForCity() {
        return this.apiUrlForCity;
    }
}
