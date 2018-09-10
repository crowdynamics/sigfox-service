package com.crowdynamics.sigfox.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crowdynamics.sigfox.model.SigfoxMessage;
import com.crowdynamics.sigfox.repository.SigfoxMessageDAO;
import com.crowdynamics.sigfox.sigfoxServiceException.SigfoxServiceException;

@Service
public class SigFoxMessageServiceImpl implements SigFoxMessageService {

	@Autowired
	private SigfoxMessageDAO sigfoxMessageDAO;

	public SigfoxMessage save(SigfoxMessage sigFoxMessage) {

		SigfoxMessage newSigFoxMessage = new SigfoxMessage();

		try {
			newSigFoxMessage = sigfoxMessageDAO.save(sigFoxMessage);

			return newSigFoxMessage;

		} catch (RuntimeException e) {

			throw new SigfoxServiceException("Error in SigfoxMessageDAO.save ", e);

		}

	}

	public Optional<SigfoxMessage> findById(Long id) {

		try {
			Optional<SigfoxMessage> sigfoxMessageList = sigfoxMessageDAO.findById(id);
			return sigfoxMessageList;

		} catch (RuntimeException e) {

			throw new SigfoxServiceException("Error in SigfoxMessageDAO.findById ", e);

		}

	}

	public List<SigfoxMessage> findAll() {

		try {
			List<SigfoxMessage> sigfoxMessageList = sigfoxMessageDAO.findAll();

			return sigfoxMessageList;
		}

		catch (RuntimeException e) {
			throw new SigfoxServiceException("Error in SigfoxMessageDAO.findAll ", e);

		}
	}

}