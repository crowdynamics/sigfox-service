package com.crowdynamics.sigfox.web;

import com.crowdynamics.sigfox.domain.SigfoxMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sigfox")
public class SigfoxController {

	@RequestMapping (method = RequestMethod.POST)
	public ResponseEntity<SigfoxMessage> create(@RequestBody SigfoxMessage sigfoxMessage)	{
	
		System.out.println(sigfoxMessage);
		
		return new ResponseEntity<>( sigfoxMessage, HttpStatus.CREATED);
	}

}
