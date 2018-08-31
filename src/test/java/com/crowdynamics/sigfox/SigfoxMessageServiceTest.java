package com.crowdynamics.sigfox;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.crowdynamics.sigfox.model.SigfoxMessage;
import com.crowdynamics.sigfox.services.SigFoxMessageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SigfoxMessageServiceTest {

    private static final Long ID = 1L;
	private static final String DEVICE_ID = "TEST01";
	private static final Timestamp MESSAGE_DATE = new Timestamp(new GregorianCalendar(2018, Calendar.SEPTEMBER, 1).getTime().getTime());
	private static final int SEQ_NUMBER = 1;
	private static final String RECEPTION_ID = "2";
	private static final BigDecimal RECEPTION_SSI = new BigDecimal(3);
	private static final BigDecimal RECEPTION_SNR = new BigDecimal(4) ;
	private static final BigDecimal GEO_LOC_LAT = new BigDecimal(5);
	private static final BigDecimal GEO_LOC_LONG = new BigDecimal(6);
	private static final BigDecimal GEO_LOC_RADIUS = new BigDecimal(7);

    @Autowired
    private SigFoxMessageService sigfoxMessageService;
	
	/**
	 * Test crear mensaje: Se llama al servicio de creacion de mensajes
	 * y devuelve un mensaje igual al pasado con el ID obtenido en DB
	 */
    @Test
    public void testCreateMessage() {
        Assert.fail("not yet implemented");
    }

	
	/**
	 * Test obtener todos los mensajes: Devuelve una lista vacia si no hay mensajes
	 */
    @Test
    @Sql({"classpath:insertSigFoxMessage.sql"})
    public void testFindAll(){
    	
    	List<SigfoxMessage> sigFoxMessageList =sigfoxMessageService.findAll();
    	
    	Assert.assertNotNull(sigFoxMessageList);
    	Assert.assertEquals(1, sigFoxMessageList.size());
    	
    	Assert.assertEquals(ID, sigFoxMessageList.get(0).getId());
    	Assert.assertEquals(DEVICE_ID, sigFoxMessageList.get(0).getDeviceId());
    	Assert.assertEquals(MESSAGE_DATE, sigFoxMessageList.get(0).getMessageDate());
    	Assert.assertEquals(SEQ_NUMBER, sigFoxMessageList.get(0).getSeqnumer());
    	Assert.assertEquals(RECEPTION_ID, sigFoxMessageList.get(0).getReceptionId());
    	Assert.assertEquals(RECEPTION_SSI, sigFoxMessageList.get(0).getReceptionRssi());
    	Assert.assertEquals(RECEPTION_SNR, sigFoxMessageList.get(0).getReceptionSnr());
    	Assert.assertEquals(GEO_LOC_LAT, sigFoxMessageList.get(0).getGeolocLat());mvn c
    	Assert.assertEquals(GEO_LOC_LONG, sigFoxMessageList.get(0).getGeolocLon());
    	Assert.assertEquals(GEO_LOC_RADIUS, sigFoxMessageList.get(0).getGeolocRadius());
    }
	
	/**
	 * Test obtener todos los mensajes: Devuelve una lista vacia con un elemento previamente
	 * insertado y su contenido es el esperado
	 */
	
	
	/**
	 * Test obtener mensaje: Obtiene un mensaje por id, devuelve null al no haber ningun mensaje en DB
	 */
	
	/**
	 * Test obtener mensaje: Obtiene un mensaje por id, devuelve el objeto que se ha insertado previamente
	 */
}
