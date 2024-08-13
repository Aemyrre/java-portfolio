package com.example.weather_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD	)
class WeatherApiApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void shouldReturnAWeatherUsingLatitudeAndLongitudePathVariables() {
		ResponseEntity<String> response = restTemplate
			.getForEntity("/weather/getWeather/lat/44.34/lon/10.99", String.class);
		System.out.println("Response: " + response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		Number timezone = documentContext.read("$.timezone");
		assertNotNull(timezone);
	}

	@Test
	void shouldNotReturnAWeatherUsingInvalidLatitudeAndLongitudePathVariables() {
		ResponseEntity<String> response = restTemplate
			.getForEntity("/weather/getWeather/lat/A/lon/10.99", String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	void shouldNotReturnWeatherWhenLatOrLonAreEmptyPathVariable() {
		ResponseEntity<String> response = restTemplate
			.getForEntity("/weather/getWeather/lat/ /lon/ ", String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		System.out.printf("Error Message: %s", response.getBody());
	}

	@Test
	void shouldReturnAWeatherUsingLatitudeAndLongitudeRequestParam() {
		ResponseEntity<String> response = restTemplate
			.getForEntity("/weather/search-by-lat-and-lon?lat=44.34&lon=10.99", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void shouldNotReturnWeatherWhenLatOrLonAreEmptyRequestParam() {
		ResponseEntity<String> response = restTemplate
			.getForEntity("/weather/search-by-lat-and-lon?lat=  &lon=  ", String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		System.out.printf("Error Message: %s", response.getBody());
	}

	@Test
	void shouldNotReturnAWeatherUsingInvalidLatitudeAndLongitudeRequestParam() {
		ResponseEntity<String> response = restTemplate
			.getForEntity("/weather/search-by-lat-and-lon?lat=A&lon=BC", String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	void shouldReturnGeocodingUsingACityForAllAvailableCities() {
		ResponseEntity<String> response = restTemplate
			.getForEntity("/weather/search-by-city?city=Manila", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		Number timezone = documentContext.read("$.timezone");
		String cityName = documentContext.read("$.name");

		assertEquals(28800, timezone);
		assertNotNull(cityName);
	}

	@Test
	void shouldNotReturnWeatherWhenPassedAnInvalidCityName() {
		ResponseEntity<String> response = restTemplate
			.getForEntity("/weather/search-by-city?city=Mapinila", String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		System.out.println(String.format("Error Message: %s", response.getBody()));
	}

	@Test
	void shouldNotReturnWeatherWhenCityNameIsEmpty() {
		ResponseEntity<String> response = restTemplate
			.getForEntity("/weather/search-by-city?city=   ", String.class);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		System.out.printf("Error Message: %s", response.getBody());
	}

}
