package com.crowdynamics.sigfox.converters;

import com.crowdynamics.sigfox.dto.GeolocDto;
import com.crowdynamics.sigfox.dto.ReceptionDto;
import com.crowdynamics.sigfox.dto.SigfoxMessageDto;
import com.crowdynamics.sigfox.model.SigfoxMessage;

public class SigfoxMessageToDtoConverter {

	public static SigfoxMessageDto convertToDto(SigfoxMessage sigfoxMessage){

		SigfoxMessageDto sigfoxMessageDto = null;

		if (sigfoxMessage != null) {
			sigfoxMessageDto = new SigfoxMessageDto();

			GeolocDto geoLocDto = new GeolocDto();
			geoLocDto.setLatitude(sigfoxMessage.getGeolocLat());
			geoLocDto.setLongitude(sigfoxMessage.getGeolocLon());
			geoLocDto.setRadius(sigfoxMessage.getGeolocRadius());

			ReceptionDto receptionDto = new ReceptionDto();
			receptionDto.setId(sigfoxMessage.getDeviceId());
			receptionDto.setRssi(sigfoxMessage.getReceptionRssi());
			receptionDto.setSnr(sigfoxMessage.getReceptionSnr());

			sigfoxMessageDto.setId(sigfoxMessage.getId());

			sigfoxMessageDto.setDeviceId(sigfoxMessage.getDeviceId());
			sigfoxMessageDto.setSeqNumber(sigfoxMessage.getSeqnumer());
			sigfoxMessageDto.setTime(sigfoxMessage.getMessageDate());

			sigfoxMessageDto.setGeoloc(geoLocDto);
			sigfoxMessageDto.setReception(receptionDto);
		}

		return sigfoxMessageDto;
		
		
		
	}

	
}
