package com.crowdynamics.sigfox.web;

public class Geoloc {
	
	public String latitude;
	public String longitude;
	public String radius;
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getRadius() {
		return radius;
	}
	public void setRadius(String radius) {
		this.radius = radius;
	}
	@Override
	public String toString() {
		return "Geoloc [latitude=" + latitude + ", longitude=" + longitude + ", radius=" + radius + "]";
	}
	
	

}
