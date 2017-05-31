package com.weatherforecast.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.weatherforecast.services.contracts.UserService;
import com.weatherforecast.services.contracts.WeatherService;

@RestController
@RequestMapping("/api/")
public class WeatherForecastController {
	private WeatherService weatherService;
	private UserService userService;

	@Autowired
	public WeatherForecastController(WeatherService weatherService, UserService userService) {
		this.weatherService = weatherService;
		this.userService = userService;
	}
	
	@RequestMapping(value = "hi/{city}", method = RequestMethod.GET, produces = "application/json")
	public String hello(@PathVariable(value = "city") String city){
		String forecast;
		try {
			forecast = this.weatherService.getForecast(city);
		} catch (Exception e) {
			e.printStackTrace();
			forecast = e.getMessage();
		}
		return forecast;
	}
	
	
	@RequestMapping(value = "forecast/{city}", method = RequestMethod.GET, produces = "application/json")
	public String forecast(@PathVariable(value = "city") String city, HttpServletRequest request) {
		String errorMessage = "error";

		if (city.isEmpty() || city == null) {
			return errorMessage;
		}

		String forecast;
		try {
			forecast = this.weatherService.getForecast(city);
		} catch (Exception e) {
			e.printStackTrace();
			forecast = errorMessage;
		}

		String userIP = request.getRemoteAddr();

		this.userService.saveUserSearchData(userIP, city);

		return forecast;
	}
}
