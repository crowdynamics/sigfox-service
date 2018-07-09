package com.crowdynamics.sigfox.web;

import com.crowdynamics.sigfox.dao.jpa.SigfoxMessageDAO;
import com.crowdynamics.sigfox.domain.SigfoxMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sigfox")
public class SigfoxController {

	@Autowired
	private SigfoxMessageDAO sigfoxMessageRepository;

	@RequestMapping (method = RequestMethod.POST)
	public ResponseEntity<SigfoxMessage> create(@RequestBody SigfoxMessage sigfoxMessage)	{
	
		System.out.println(sigfoxMessage);
		
		return new ResponseEntity<>( sigfoxMessage, HttpStatus.CREATED);
	}

    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<List<com.crowdynamics.sigfox.entity.SigfoxMessagesEntity>> get()	{

        return new ResponseEntity<>( sigfoxMessageRepository.findAll(), HttpStatus.OK);
    }

}
