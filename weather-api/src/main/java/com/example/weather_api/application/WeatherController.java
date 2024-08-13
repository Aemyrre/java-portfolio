package com.example.weather_api.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;
    
    @GetMapping("/getWeather/lat/{requestedLat}/lon/{requestedLon}")
    public ResponseEntity<String> getWeatherUsingLatAndLonPathVariable(@PathVariable Double requestedLat, @PathVariable Double requestedLon) {
        if (requestedLat != null && requestedLon != null) {
            return weatherService.getWeatherWithLatAndLongPathVariables(requestedLat, requestedLon);
        }
        
        return ResponseEntity.badRequest().body("Weather not found.");
    }

    @GetMapping("/search-by-lat-and-lon")
    public ResponseEntity<String> getWeatherUsingLatAndLonRequestParam(@RequestParam Double lat, @RequestParam Double lon) {
        if (lat != null && lon != null) {
            return weatherService.getWeatherusingLatAndLonRequestParam(lat, lon);
        }

        return ResponseEntity.badRequest().body("Weather not found.");
    }

    @GetMapping("/search-by-city")
    public ResponseEntity<String> getGeocodeUsingACity(@RequestParam String city) {
        if (city != null) {
            return weatherService.getGeocodeUsingACity(city);
        }
        
        return ResponseEntity.badRequest().body("City not found.");
    }
    
    
    
}
