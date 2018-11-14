package com.crowdynamics.sigfox.services;

import java.util.List;

import com.crowdynamics.sigfox.model.SigfoxMessage;

public interface SigFoxMessageService {

	SigfoxMessage save(SigfoxMessage sigfoxMessage) ;

	SigfoxMessage findById(Long id);

	List<SigfoxMessage> findByDeviceId(String deviceID);

}