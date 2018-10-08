package com.crowdynamics.sigfox.services;

import com.crowdynamics.sigfox.exceptions.SigfoxServiceException;
import com.crowdynamics.sigfox.model.SigfoxMessage;
import com.crowdynamics.sigfox.repository.SigfoxMessageDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@Service
public class SigFoxMessageServiceImpl implements SigFoxMessageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SigFoxMessageServiceImpl.class);

	@Autowired
	private SigfoxMessageDAO sigfoxMessageDAO;

	@Transactional(rollbackFor = Exception.class)
	public SigfoxMessage save(SigfoxMessage sigFoxMessage) {

		return (SigfoxMessage) performOperation(() -> sigfoxMessageDAO.save(sigFoxMessage));
	}

	@Transactional(readOnly = true)
	public SigfoxMessage findById(Long id) {

		return ((Optional<SigfoxMessage>) performOperation(() -> sigfoxMessageDAO.findById(id))).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<SigfoxMessage> findAll() {

		return (List<SigfoxMessage>) performOperation(() -> sigfoxMessageDAO.findAll());
	}

	private Object performOperation(Callable<?> function)	{

		Object result = null;

		try {

			result = function.call();

		} catch (Exception e) {
			SigFoxMessageServiceImpl.handleUnexpectedError(e);
		}

		return result;
	}

	private static void handleUnexpectedError(Exception exception)	{

		LOGGER.error("Error procesando operacion", exception);

		throw new SigfoxServiceException("SigofxMessageServiceError", exception);
	}

}