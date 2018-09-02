package com.crowdynamics.sigfox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crowdynamics.sigfox.model.SigfoxMessage;
import com.crowdynamics.sigfox.repository.SigfoxMessageDAO;

@Service
public class SigFoxMessageServiceImpl implements SigFoxMessageService {

	@Autowired
	private SigfoxMessageDAO sigfoxMessageDAO;

	public SigfoxMessage save(SigfoxMessage sigFoxMessage) {
		return sigfoxMessageDAO.save(sigFoxMessage);
	}

	public Optional<SigfoxMessage> findById(Long id) {
		return sigfoxMessageDAO.findById(id);
	}

	public List<SigfoxMessage> findAll() {
		return sigfoxMessageDAO.findAll();
	}

}