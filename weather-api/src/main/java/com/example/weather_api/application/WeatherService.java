package com.example.weather_api.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    
    @Autowired
    private WeatherConfig config;
    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> getWeatherWithLatAndLongPathVariables(Double requestedLat, Double requestedLon) {
        
        
        String url = weatheApiUrl(requestedLon, requestedLon);
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> getWeatherusingLatAndLonRequestParam(Double lat, Double lon) {
        if (lat == null || lon == null) {
            return ResponseEntity.badRequest().body("Invalid latitude and longitude");
        }
        
        String url = weatheApiUrl(lat, lon);
        return restTemplate.getForEntity(url, String.class);
    }

    public ResponseEntity<String> getGeocodeUsingACity(String city) {
        String geocodingUrl = String.format("%s/direct?q=%s&appid=%s", config.getApirUrlForCity(), city, config.getApiKey());
        ResponseEntity<GeocodingResponse[]> geocodingResponse = restTemplate.getForEntity(geocodingUrl, GeocodingResponse[].class);
        
        if (geocodingResponse.getBody() != null && geocodingResponse.getBody().length > 0) {
            double latitude = geocodingResponse.getBody()[0].lat();
            double longitude = geocodingResponse.getBody()[0].lon();

            String url = weatheApiUrl(latitude, longitude);
            return restTemplate.getForEntity(url, String.class);
        }

        return ResponseEntity.badRequest().body("City not found.");
    }

    private String weatheApiUrl(Double latitude, Double longitude) {
        return String.format("%s/weather?lat=%s&lon=%s&appid=%s", config.getApiUrlForLatAndLon(), latitude, longitude, config.getApiKey());
    }
}
