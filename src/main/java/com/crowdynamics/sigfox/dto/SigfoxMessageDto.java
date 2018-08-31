package com.crowdynamics.sigfox.dto;

public class SigfoxMessageDto {
	
	private Long id;
	private String deviceId;
	private String time;
	private String seqNumber;
	private ReceptionDto reception;
	private GeolocDto geoloc;
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSeqNumber() {
		return seqNumber;
	}
	public void setSeqNumber(String seqNumber) {
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
