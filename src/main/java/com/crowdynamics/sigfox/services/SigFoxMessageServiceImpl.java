package com.crowdynamics.sigfox.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crowdynamics.sigfox.model.SigfoxMessage;
import com.crowdynamics.sigfox.repository.SigfoxMessageDAO;
import com.crowdynamics.sigfox.sigfoxServiceException.SigfoxServiceException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SigFoxMessageServiceImpl implements SigFoxMessageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SigFoxMessageServiceImpl.class);

	@Autowired
	private SigfoxMessageDAO sigfoxMessageDAO;

	@Transactional(rollbackFor = Exception.class)
	public SigfoxMessage save(SigfoxMessage sigFoxMessage) {

		SigfoxMessage newSigFoxMessage = null;

		try {

			newSigFoxMessage = sigfoxMessageDAO.save(sigFoxMessage);

		} catch (RuntimeException e) {

			LOGGER.error("Error guardanda mensaje", e);

			throw new SigfoxServiceException("Error in SigfoxMessageDAO.save ", e);
		}

		return newSigFoxMessage;
	}

	@Transactional(readOnly = true)
	public SigfoxMessage findById(Long id) {

		SigfoxMessage result = null;

		try {

			result = sigfoxMessageDAO.findById(id).orElse(null);

		} catch (RuntimeException e) {

			throw new SigfoxServiceException("Error in SigfoxMessageDAO.findById ", e);
		}

		return result;
	}

	@Transactional(readOnly = true)
	public List<SigfoxMessage> findAll() {

		List<SigfoxMessage> sigfoxMessageList = null;

		try {

			sigfoxMessageList = sigfoxMessageDAO.findAll();

		} catch (RuntimeException e) {
			throw new SigfoxServiceException("Error in SigfoxMessageDAO.findAll ", e);
		}

		return sigfoxMessageList;
	}

}