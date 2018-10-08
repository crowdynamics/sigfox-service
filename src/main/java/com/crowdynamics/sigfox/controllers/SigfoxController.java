package com.crowdynamics.sigfox.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crowdynamics.sigfox.converters.SigfoxMessageDtoToMessageConverter;
import com.crowdynamics.sigfox.converters.SigfoxMessageToDtoConverter;
import com.crowdynamics.sigfox.dto.SigfoxMessageDto;
import com.crowdynamics.sigfox.model.SigfoxMessage;
import com.crowdynamics.sigfox.services.SigFoxMessageServiceImpl;

@RestController
@RequestMapping(value = "/sigfox")
public class SigfoxController {

	private SigFoxMessageServiceImpl sigFoxMessageService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SigfoxMessageDto> create(@RequestBody SigfoxMessageDto sigfoxMessageDto) {

		// Mapeo entre el DTO y el Model (Tabla BBDD)
		// Una vez está el Model Mapeado, se guarda en BBDD
		SigfoxMessage newSigfoxMessage = sigFoxMessageService
				.save(SigfoxMessageDtoToMessageConverter.convertToMessage(sigfoxMessageDto));

		// Mapeo entre Model y DTO
		return new ResponseEntity<>(
				SigfoxMessageToDtoConverter.convertToDto(newSigfoxMessage), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SigfoxMessageDto>> get() {

		// Recuperamos todos los mensajes
		List<SigfoxMessage> sigfoxMessageList = sigFoxMessageService.findAll();

		// Mapeamos entre elementos
		List<SigfoxMessageDto> sigfoxMessageListDto = sigfoxMessageList.stream()
				.map(SigfoxMessageToDtoConverter::convertToDto)
				.collect(Collectors.toList());

		return new ResponseEntity<>(sigfoxMessageListDto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SigfoxMessageDto> getById(@PathVariable(value = "id") Long id) {

		// Recuperamos el mensaje
		SigfoxMessage sigfoxMessage = sigFoxMessageService.findById(id).get();

		// Mapeo entre Model y DTO
		SigfoxMessageDto sigfoxMessageDto = SigfoxMessageToDtoConverter.convertToDto(sigfoxMessage);

		return new ResponseEntity<>(sigfoxMessageDto,
				HttpStatus.OK);
	}
}
