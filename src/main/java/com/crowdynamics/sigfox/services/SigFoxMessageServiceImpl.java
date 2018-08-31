package com.crowdynamics.sigfox.services;

import java.util.List;

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

	public SigfoxMessage findById(Long id) {
		return null;
	}

	public List<SigfoxMessage> findAll() {
		return sigfoxMessageDAO.findAll();
	}

}