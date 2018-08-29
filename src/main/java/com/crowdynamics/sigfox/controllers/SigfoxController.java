package com.crowdynamics.sigfox.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crowdynamics.sigfox.model.SigfoxMessage;

@RestController
@RequestMapping(value = "/sigfox")
public class SigfoxController {


	@RequestMapping (method = RequestMethod.POST)
	public ResponseEntity<SigfoxMessage> create(@RequestBody SigfoxMessage sigfoxMessage)	{
	
		
		return null;
	}

    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<List<SigfoxMessage>> get()	{

        return null;
    }

}
