package com.crowdynamics.sigfox.dto;

import java.math.BigDecimal;

public class ReceptionDto {

	public String id;
	public BigDecimal rssi;
	public BigDecimal snr;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getRssi() {
		return rssi;
	}
	public void setRssi(BigDecimal rssi) {
		this.rssi = rssi;
	}
	public BigDecimal getSnr() {
		return snr;
	}
	public void setSnr(BigDecimal snr) {
		this.snr = snr;
	}
	@Override
	public String toString() {
		return "Reception [id=" + id + ", rssi=" + rssi + ", snr=" + snr + "]";
	}
	
}
