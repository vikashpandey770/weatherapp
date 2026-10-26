package com.example.weatherapp.dto;

import java.util.List;

import javax.tools.DocumentationTool.Location;

public class GeocodingResponse {

	private List<Location> results;
	
	public List<Location>getResults(){
		return results;
		
	}
	public void setResults(List<Location>results) {
		this.results=results;
	}
	
	public static class Location{
		private String name;
		private Double latitude;
		private Double longitude;
		private String country;
		private String admin1;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getLatitude() {
			return latitude;
		}
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}
		public Double getLongitude() {
			return longitude;
		}
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getAdmin1() {
			return admin1;
		}
		public void setAdmin1(String admin1) {
			this.admin1 = admin1;
		}
		
	}
	
}
