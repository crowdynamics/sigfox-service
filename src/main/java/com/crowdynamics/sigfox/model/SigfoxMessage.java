package com.crowdynamics.sigfox.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sigfox_messages", schema = "public", catalog = "d9n4pkcd0ismmi")
public class SigfoxMessage {
	private Long id;
	private String deviceId;
	private Timestamp messageDate;
	private int seqnumer;
	private String receptionId;
	private BigDecimal receptionRssi;
	private BigDecimal receptionSnr;
	private BigDecimal geolocLat;
	private BigDecimal geolocLon;
	private BigDecimal geolocRadius;

	@Id
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "device_id")
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Basic
	@Column(name = "message_date")
	public Timestamp getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Timestamp messageDate) {
		this.messageDate = messageDate;
	}

	@Basic
	@Column(name = "seqnumer")
	public int getSeqnumer() {
		return seqnumer;
	}

	public void setSeqnumer(int seqnumer) {
		this.seqnumer = seqnumer;
	}

	@Basic
	@Column(name = "reception_id")
	public String getReceptionId() {
		return receptionId;
	}

	public void setReceptionId(String receptionId) {
		this.receptionId = receptionId;
	}

	@Basic
	@Column(name = "reception_rssi")
	public BigDecimal getReceptionRssi() {
		return receptionRssi;
	}

	public void setReceptionRssi(BigDecimal receptionRssi) {
		this.receptionRssi = receptionRssi;
	}

	@Basic
	@Column(name = "reception_snr")
	public BigDecimal getReceptionSnr() {
		return receptionSnr;
	}

	public void setReceptionSnr(BigDecimal receptionSnr) {
		this.receptionSnr = receptionSnr;
	}

	@Basic
	@Column(name = "geoloc_lat")
	public BigDecimal getGeolocLat() {
		return geolocLat;
	}

	public void setGeolocLat(BigDecimal geolocLat) {
		this.geolocLat = geolocLat;
	}

	@Basic
	@Column(name = "geoloc_lon")
	public BigDecimal getGeolocLon() {
		return geolocLon;
	}

	public void setGeolocLon(BigDecimal geolocLon) {
		this.geolocLon = geolocLon;
	}

	@Basic
	@Column(name = "geoloc_radius")
	public BigDecimal getGeolocRadius() {
		return geolocRadius;
	}

	public void setGeolocRadius(BigDecimal geolocRadius) {
		this.geolocRadius = geolocRadius;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		SigfoxMessage that = (SigfoxMessage) o;
		return id == that.id && seqnumer == that.seqnumer && Objects.equals(deviceId, that.deviceId)
				&& Objects.equals(messageDate, that.messageDate) && Objects.equals(receptionId, that.receptionId)
				&& Objects.equals(receptionRssi, that.receptionRssi) && Objects.equals(receptionSnr, that.receptionSnr)
				&& Objects.equals(geolocLat, that.geolocLat) && Objects.equals(geolocLon, that.geolocLon)
				&& Objects.equals(geolocRadius, that.geolocRadius);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, deviceId, messageDate, seqnumer, receptionId, receptionRssi, receptionSnr, geolocLat,
				geolocLon, geolocRadius);
	}
}
