INSERT INTO sigfox_messages
    (
	 device_id, message_date, seqnumer, reception_id,reception_rssi, reception_snr, geoloc_lat, geoloc_lon, geoloc_radius)
	VALUES 
	( 'TEST01', TO_TIMESTAMP('01/09/2018', 'DD/MM/YYYY'), 1, 2, 3, 4, 5, 6, 7);