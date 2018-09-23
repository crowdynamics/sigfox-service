package com.crowdynamics.sigfox.converters;

import com.crowdynamics.sigfox.dto.GeolocDto;
import com.crowdynamics.sigfox.dto.ReceptionDto;
import com.crowdynamics.sigfox.dto.SigfoxMessageDto;
import com.crowdynamics.sigfox.model.SigfoxMessage;

public class SigfoxMessageToDtoConverter {

	public static SigfoxMessageDto convertToDto(SigfoxMessage sigfoxMessage){
		
		GeolocDto geoLocDto=new GeolocDto();
		geoLocDto.setLatitude(sigfoxMessage.getGeolocLat());
		geoLocDto.setLongitude(sigfoxMessage.getGeolocLon());
		geoLocDto.setRadius(sigfoxMessage.getGeolocRadius());
		
		ReceptionDto receptionDto=new ReceptionDto();
		receptionDto.setId(sigfoxMessage.getDeviceId());
		receptionDto.setRssi(sigfoxMessage.getReceptionRssi());
		receptionDto.setSnr(sigfoxMessage.getReceptionSnr());
		
		SigfoxMessageDto sigfoxMessageDto= new SigfoxMessageDto();
		sigfoxMessageDto.setDeviceId(sigfoxMessage.getDeviceId());
		sigfoxMessageDto.setId(sigfoxMessage.getId());
		sigfoxMessageDto.setReception(receptionDto);
		sigfoxMessageDto.setSeqNumber(sigfoxMessage.getSeqnumer());
		sigfoxMessageDto.setTime(sigfoxMessage.getMessageDate());
		
		return sigfoxMessageDto;
		
		
		
	}

	
}
