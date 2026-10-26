package com.example.weatherapp.dto;

public class WeatherResponse {

	private String city;
	private String country;
	private String time;
	private Double temperature;
	private Double feelsLike;
	private Integer humidity;
	private Double precipitation;
	private String condition;
	private Double windSpeed;
	private Integer windDirection;
	private String dayStatus;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(Double feelsLike) {
		this.feelsLike = feelsLike;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public Double getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(Double precipitation) {
		this.precipitation = precipitation;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Integer getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}
	public String getDayStatus() {
		return dayStatus;
	}
	public void setDayStatus(String dayStatus) {
		this.dayStatus = dayStatus;
	}
	
}
