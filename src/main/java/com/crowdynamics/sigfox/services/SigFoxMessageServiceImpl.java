package com.crowdynamics.sigfox.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crowdynamics.sigfox.model.SigfoxMessage;
import com.crowdynamics.sigfox.repository.SigfoxMessageDAO;
import com.crowdynamics.sigfox.exceptions.SigfoxServiceException;
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
			SigFoxMessageServiceImpl.handleUnexpectedError(e);
		}

		return newSigFoxMessage;
	}

	@Transactional(readOnly = true)
	public SigfoxMessage findById(Long id) {

		SigfoxMessage result = null;

		try {

			result = sigfoxMessageDAO.findById(id).orElse(null);

		} catch (RuntimeException e) {
			SigFoxMessageServiceImpl.handleUnexpectedError(e);
		}

		return result;
	}

	@Transactional(readOnly = true)
	public List<SigfoxMessage> findAll() {

		List<SigfoxMessage> sigfoxMessageList = null;

		try {

			sigfoxMessageList = sigfoxMessageDAO.findAll();

		} catch (RuntimeException e) {
			SigFoxMessageServiceImpl.handleUnexpectedError(e);
		}

		return sigfoxMessageList;
	}

	private static void handleUnexpectedError(RuntimeException exception)	{

		LOGGER.error("Error procesando operacion", exception);

		throw new SigfoxServiceException("SigofxMessageServiceError", exception);
	}

}