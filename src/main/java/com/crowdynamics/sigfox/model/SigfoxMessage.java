package com.crowdynamics.sigfox.model;

public class SigfoxMessage {
	
	private Long id;
	private String deviceId;
	private String time;
	private String seqNumber;
	private Reception reception;
	private Geoloc geoloc;
	
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
	
	
	public Reception getReception() {
		return reception;
	}
	public void setReception(Reception reception) {
		this.reception = reception;
	}
	public Geoloc getGeoloc() {
		return geoloc;
	}
	public void setGeoloc(Geoloc geoloc) {
		this.geoloc = geoloc;
	}	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
