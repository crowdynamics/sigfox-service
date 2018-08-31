package com.crowdynamics.sigfox.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crowdynamics.sigfox.dto.SigfoxMessageDto;

@RestController
@RequestMapping(value = "/sigfox")
public class SigfoxController {


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SigfoxMessageDto> create(@RequestBody SigfoxMessageDto sigfoxMessage)	{
	
		
		return null;
	}

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SigfoxMessageDto>> get()	{

        return null;
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<SigfoxMessageDto>> getById(@PathVariable(value = "id") Long id)	{
        


        return null;
    }

}
