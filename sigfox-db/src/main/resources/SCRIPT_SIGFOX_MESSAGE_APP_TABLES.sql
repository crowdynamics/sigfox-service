<<<<<<< HEAD
CREATE TABLE SIGFOX_MESSAGES (
ID BIGSERIAL, 
DEVICE_ID VARCHAR(6) NOT NULL,
MESSAGE_DATE TIMESTAMP NOT NULL,
SEQNUMER NUMERIC(10,0) NOT NULL,
RECEPTION_ID VARCHAR(5) NOT NULL,
RECEPTION_RSSI NUMERIC (5,2) NOT NULL,
RECEPTION_SNR NUMERIC (5,2) NOT NULL,
GEOLOC_LAT NUMERIC (18,16) NOT NULL,
GEOLOC_LON NUMERIC (18,16) NOT NULL,
GEOLOC_RADIUS NUMERIC (6,2) NOT NULL,

PRIMARY KEY (ID)
);