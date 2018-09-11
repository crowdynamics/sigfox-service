package com.crowdynamics.sigfox.dto;

import java.sql.Timestamp;

public class SigfoxMessageDto {
	
	private Long id;
	private String deviceId;
	private Timestamp time;
	private Integer seqNumber;
	private ReceptionDto reception;
	private GeolocDto geoloc;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Integer getSeqNumber() {
		return seqNumber;
	}
	public void setSeqNumber(Integer seqNumber) {
		this.seqNumber = seqNumber;
	}
	
	
	public ReceptionDto getReception() {
		return reception;
	}
	public void setReception(ReceptionDto reception) {
		this.reception = reception;
	}
	public GeolocDto getGeoloc() {
		return geoloc;
	}
	public void setGeoloc(GeolocDto geoloc) {
		this.geoloc = geoloc;
	}	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
