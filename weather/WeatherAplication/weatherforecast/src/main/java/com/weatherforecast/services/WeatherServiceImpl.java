package com.weatherforecast.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.weatherforecast.services.contracts.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
	private final String USER_AGENT = "Mozilla/5.0";
	private final String BASE_URL = "https://api.apixu.com/v1/current.json?key=6b6f88a119de42709b3190219173105&q=";
	
	@Override
	public String getForecast(String town) throws Exception{
		
		String url = this.BASE_URL + town;

		
		URL urlObj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();


		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		return response.toString();
	}
}
