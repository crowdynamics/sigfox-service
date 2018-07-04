package com.crowdynamics.sigfox.domain;

public class Reception {

	public String id;
	public String rssi;
	public String snr;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getRssi() {
		return rssi;
	}
	public void setRssi(String rssi) {
		this.rssi = rssi;
	}
	public String getSnr() {
		return snr;
	}
	public void setSnr(String snr) {
		this.snr = snr;
	}
	@Override
	public String toString() {
		return "Reception [id=" + id + ", rssi=" + rssi + ", snr=" + snr + "]";
	}
	
}
