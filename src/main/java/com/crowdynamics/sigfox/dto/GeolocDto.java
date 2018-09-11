package com.crowdynamics.sigfox.dto;

import java.math.BigDecimal;

public class GeolocDto {
	
	public BigDecimal latitude;
	public BigDecimal longitude;
	public BigDecimal radius;
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getRadius() {
		return radius;
	}
	public void setRadius(BigDecimal radius) {
		this.radius = radius;
	}
	@Override
	public String toString() {
		return "Geoloc [latitude=" + latitude + ", longitude=" + longitude + ", radius=" + radius + "]";
	}
	
	

}
