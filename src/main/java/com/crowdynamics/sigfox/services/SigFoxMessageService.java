package com.crowdynamics.sigfox.services;

import java.util.List;
import java.util.Optional;

import com.crowdynamics.sigfox.model.SigfoxMessage;

public interface SigFoxMessageService {

	SigfoxMessage save(SigfoxMessage sigfoxMessage) ;

	Optional<SigfoxMessage> findById(Long id);

	List<SigfoxMessage> findAll();

}