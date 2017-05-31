package com.weatherforecast.services.contracts;

public interface WeatherService {

	String getForecast(String town) throws Exception;

}