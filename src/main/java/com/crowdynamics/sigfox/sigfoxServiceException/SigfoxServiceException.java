package com.crowdynamics.sigfox.sigfoxServiceException;

public class SigfoxServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SigfoxServiceException(String message, Throwable cause) {
		super(message, cause);
	}



	public SigfoxServiceException(String message) {
		super(message);
	}

	public SigfoxServiceException(Throwable cause) {
		super(cause);
	}



}