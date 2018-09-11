package com.crowdynamics.sigfox.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crowdynamics.sigfox.dto.GeolocDto;
import com.crowdynamics.sigfox.dto.ReceptionDto;
import com.crowdynamics.sigfox.dto.SigfoxMessageDto;
import com.crowdynamics.sigfox.model.SigfoxMessage;
import com.crowdynamics.sigfox.repository.SigfoxMessageDAO;

@RestController
@RequestMapping(value = "/sigfox")
public class SigfoxController {

	private SigfoxMessageDAO sigfoxMessageDAO;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SigfoxMessageDto> create(@RequestBody SigfoxMessageDto sigfoxMessageDto) {

		// Mapeo entre el DTO y el Model (Tabla BBDD)
		SigfoxMessage sigfoxMessage = new SigfoxMessage();
		sigfoxMessage.setDeviceId(sigfoxMessageDto.getDeviceId());
		sigfoxMessage.setId(sigfoxMessageDto.getId());
		sigfoxMessage.setGeolocLat(sigfoxMessageDto.getGeoloc().getLatitude());
		sigfoxMessage.setGeolocLon(sigfoxMessageDto.getGeoloc().getLongitude());
		sigfoxMessage.setGeolocRadius(sigfoxMessageDto.getGeoloc().getRadius());
		sigfoxMessage.setMessageDate(sigfoxMessageDto.getTime());
		sigfoxMessage.setReceptionId(sigfoxMessageDto.getReception().getId());
		sigfoxMessage.setReceptionRssi(sigfoxMessageDto.getReception().getRssi());
		sigfoxMessage.setReceptionSnr(sigfoxMessageDto.getReception().getSnr());
		sigfoxMessage.setSeqnumer(sigfoxMessageDto.getSeqNumber());

		// Una vez está el Model Mapeado, se guarda en BBDD
		SigfoxMessage newSigfoxMessage = sigfoxMessageDAO.save(sigfoxMessage);

		// Mapeo entre Model y DTO
		SigfoxMessageDto newSigfoxMessageDto = new SigfoxMessageDto();
		GeolocDto geoLocDto = new GeolocDto();
		geoLocDto.setLatitude(newSigfoxMessage.getGeolocLat());
		geoLocDto.setLongitude(newSigfoxMessage.getGeolocLon());
		geoLocDto.setRadius(newSigfoxMessage.getGeolocRadius());

		ReceptionDto receptionDto = new ReceptionDto();
		receptionDto.setId(newSigfoxMessage.getDeviceId());
		receptionDto.setRssi(newSigfoxMessage.getReceptionRssi());
		receptionDto.setSnr(newSigfoxMessage.getReceptionSnr());

		newSigfoxMessageDto.setDeviceId(newSigfoxMessage.getDeviceId());
		newSigfoxMessageDto.setId(newSigfoxMessage.getId());
		newSigfoxMessageDto.setReception(receptionDto);
		newSigfoxMessageDto.setSeqNumber(newSigfoxMessage.getSeqnumer());
		newSigfoxMessageDto.setTime(newSigfoxMessage.getMessageDate());

		ResponseEntity<SigfoxMessageDto> response = new ResponseEntity<SigfoxMessageDto>(newSigfoxMessageDto,
				HttpStatus.OK);

		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SigfoxMessageDto>> get() {

		// Recuperamos todos los mensajes
		List<SigfoxMessage> sigfoxMessageList = sigfoxMessageDAO.findAll();

		// Mapeamos entre elementos
		List<SigfoxMessageDto> sigfoxMessageListDto = new ArrayList<SigfoxMessageDto>();
		SigfoxMessageDto sigfoxMessageDto = new SigfoxMessageDto();
		GeolocDto geoLocDto = new GeolocDto();
		ReceptionDto receptionDto = new ReceptionDto();

		for (SigfoxMessage sigfoxMessage : sigfoxMessageList) {
			// Mapeo entre Model y DTO elemento a elemento

			geoLocDto.setLatitude(sigfoxMessage.getGeolocLat());
			geoLocDto.setLongitude(sigfoxMessage.getGeolocLon());
			geoLocDto.setRadius(sigfoxMessage.getGeolocRadius());

			receptionDto.setId(sigfoxMessage.getDeviceId());
			receptionDto.setRssi(sigfoxMessage.getReceptionRssi());
			receptionDto.setSnr(sigfoxMessage.getReceptionSnr());

			sigfoxMessageDto.setDeviceId(sigfoxMessage.getDeviceId());
			sigfoxMessageDto.setId(sigfoxMessage.getId());
			sigfoxMessageDto.setReception(receptionDto);
			sigfoxMessageDto.setSeqNumber(sigfoxMessage.getSeqnumer());
			sigfoxMessageDto.setTime(sigfoxMessage.getMessageDate());
			sigfoxMessageListDto.add(sigfoxMessageDto);
		}
		ResponseEntity<List<SigfoxMessageDto>> response = new ResponseEntity<List<SigfoxMessageDto>>(
				sigfoxMessageListDto, HttpStatus.OK);

		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<SigfoxMessageDto> getById(@PathVariable(value = "id") Long id) {
		// Recuperamos el mensaje
		SigfoxMessage sigfoxMessage = sigfoxMessageDAO.findById(id).get();
		
		// Mapeo entre Model y DTO
		SigfoxMessageDto sigfoxMessageDto = new SigfoxMessageDto();
		GeolocDto geoLocDto = new GeolocDto();
		ReceptionDto receptionDto = new ReceptionDto();

		geoLocDto.setLatitude(sigfoxMessage.getGeolocLat());
		geoLocDto.setLongitude(sigfoxMessage.getGeolocLon());
		geoLocDto.setRadius(sigfoxMessage.getGeolocRadius());

		receptionDto.setId(sigfoxMessage.getDeviceId());
		receptionDto.setRssi(sigfoxMessage.getReceptionRssi());
		receptionDto.setSnr(sigfoxMessage.getReceptionSnr());

		sigfoxMessageDto.setDeviceId(sigfoxMessage.getDeviceId());
		sigfoxMessageDto.setId(sigfoxMessage.getId());
		sigfoxMessageDto.setReception(receptionDto);
		sigfoxMessageDto.setSeqNumber(sigfoxMessage.getSeqnumer());
		sigfoxMessageDto.setTime(sigfoxMessage.getMessageDate());

		ResponseEntity<SigfoxMessageDto> response = new ResponseEntity<SigfoxMessageDto>(sigfoxMessageDto,
				HttpStatus.OK);

		return response;
	}

}
