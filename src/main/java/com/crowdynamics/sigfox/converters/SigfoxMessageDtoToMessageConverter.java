package com.crowdynamics.sigfox.converters;

import com.crowdynamics.sigfox.dto.SigfoxMessageDto;
import com.crowdynamics.sigfox.model.SigfoxMessage;

public class SigfoxMessageDtoToMessageConverter {

	public static SigfoxMessage convertToMessage(SigfoxMessageDto sigfoxMessageDto) {

		SigfoxMessage sigfoxMessage = new SigfoxMessage();
		sigfoxMessage.setDeviceId(sigfoxMessageDto.getDeviceId());
		sigfoxMessage.setId(sigfoxMessageDto.getId());
		sigfoxMessage.setMessageDate(sigfoxMessageDto.getTime());
		sigfoxMessage.setSeqnumer(sigfoxMessageDto.getSeqNumber());
		if (sigfoxMessageDto.getGeoloc() != null) {
			sigfoxMessage.setGeolocLat(sigfoxMessageDto.getGeoloc().getLatitude());
			sigfoxMessage.setGeolocLon(sigfoxMessageDto.getGeoloc().getLongitude());
			sigfoxMessage.setGeolocRadius(sigfoxMessageDto.getGeoloc().getRadius());
		}

		if (sigfoxMessageDto.getReception() != null) {
			sigfoxMessage.setReceptionId(sigfoxMessageDto.getReception().getId());
			sigfoxMessage.setReceptionRssi(sigfoxMessageDto.getReception().getRssi());
			sigfoxMessage.setReceptionSnr(sigfoxMessageDto.getReception().getSnr());
		}

		return sigfoxMessage;

	}

}
