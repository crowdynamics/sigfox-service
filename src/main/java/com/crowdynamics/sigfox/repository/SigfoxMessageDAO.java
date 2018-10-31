package com.crowdynamics.sigfox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crowdynamics.sigfox.model.SigfoxMessage;

public interface SigfoxMessageDAO extends JpaRepository<SigfoxMessage,Long> {
	public List <SigfoxMessage> findMessageByDeviceID(String deviceID);
}
