package com.crowdynamics.sigfox;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.crowdynamics.sigfox.model.SigfoxMessage;
import com.crowdynamics.sigfox.services.SigFoxMessageService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SigfoxMessageServiceTest {

	private static final Long ID = 1L;
	private static final String DEVICE_ID = "TEST01";
	private static final Timestamp MESSAGE_DATE = new Timestamp(
			new GregorianCalendar(2018, Calendar.SEPTEMBER, 1).getTime().getTime());
	private static final Integer SEQ_NUMBER = 1;
	private static final String RECEPTION_ID = "2";
	private static final BigDecimal RECEPTION_SSI = new BigDecimal(3);
	private static final BigDecimal RECEPTION_SNR = new BigDecimal(4);
	private static final BigDecimal GEO_LOC_LAT = new BigDecimal(5);
	private static final BigDecimal GEO_LOC_LONG = new BigDecimal(6);
	private static final BigDecimal GEO_LOC_RADIUS = new BigDecimal(7);

	@Autowired
	private SigFoxMessageService sigfoxMessageService;

	/**
	 * Test crear mensaje: Se llama al servicio de creacion de mensajes y
	 * devuelve un mensaje igual al pasado con el ID obtenido en DB
	 */
	@Test
	@Sql({ "classpath:insertSigFoxMessage.sql" })
	public void testSave() {

		SigfoxMessage newSigFoxMessage = new SigfoxMessage();
		newSigFoxMessage.setDeviceId(DEVICE_ID);
		newSigFoxMessage.setGeolocLat(GEO_LOC_LAT);
		newSigFoxMessage.setGeolocLon(GEO_LOC_LONG);
		newSigFoxMessage.setGeolocRadius(GEO_LOC_RADIUS);
		// newSigFoxMessage.setId(ID);
		newSigFoxMessage.setMessageDate(MESSAGE_DATE);
		newSigFoxMessage.setReceptionId(RECEPTION_ID);
		newSigFoxMessage.setReceptionRssi(RECEPTION_SSI);
		newSigFoxMessage.setReceptionSnr(RECEPTION_SNR);
		newSigFoxMessage.setSeqnumer(SEQ_NUMBER);

		SigfoxMessage sigFoxMessage = null;

		try {
			sigFoxMessage = sigfoxMessageService.save(newSigFoxMessage);
		} catch (Exception e) {
			e.printStackTrace();

			Assert.fail("No exception is expected");
		}

		Assert.assertTrue(sigFoxMessage.getId().compareTo(1L) == 0);
		Assert.assertEquals(DEVICE_ID, sigFoxMessage.getDeviceId());
		Assert.assertEquals(MESSAGE_DATE, sigFoxMessage.getMessageDate());
		Assert.assertEquals(SEQ_NUMBER, sigFoxMessage.getSeqnumer());
		Assert.assertTrue(RECEPTION_ID.compareTo(sigFoxMessage.getReceptionId()) == 0);
		Assert.assertTrue(RECEPTION_SSI.compareTo(sigFoxMessage.getReceptionRssi()) == 0);
		Assert.assertTrue(RECEPTION_SNR.compareTo(sigFoxMessage.getReceptionSnr()) == 0);
		Assert.assertTrue(GEO_LOC_LAT.compareTo(sigFoxMessage.getGeolocLat()) == 0);
		Assert.assertTrue(GEO_LOC_LONG.compareTo(sigFoxMessage.getGeolocLon()) == 0);
		Assert.assertTrue(GEO_LOC_RADIUS.compareTo(sigFoxMessage.getGeolocRadius()) == 0);
	}

	/**
	 * Test obtener todos los mensajes: Devuelve una lista vacia si no hay
	 * mensajes
	 */
	@Test
	@Sql({ "classpath:insertSigFoxMessage.sql" })
	public void testFindAll() {

		List<SigfoxMessage> sigFoxMessageList = sigfoxMessageService.findAll();

		Assert.assertNotNull(sigFoxMessageList);
		Assert.assertEquals(1, sigFoxMessageList.size());

		Assert.assertEquals(ID, sigFoxMessageList.get(0).getId());
		Assert.assertEquals(DEVICE_ID, sigFoxMessageList.get(0).getDeviceId());
		Assert.assertEquals(MESSAGE_DATE, sigFoxMessageList.get(0).getMessageDate());
		Assert.assertEquals(SEQ_NUMBER, sigFoxMessageList.get(0).getSeqnumer());
		Assert.assertTrue(RECEPTION_ID.compareTo(sigFoxMessageList.get(0).getReceptionId()) == 0);
		Assert.assertTrue(RECEPTION_SSI.compareTo(sigFoxMessageList.get(0).getReceptionRssi()) == 0);
		Assert.assertTrue(RECEPTION_SNR.compareTo(sigFoxMessageList.get(0).getReceptionSnr()) == 0);
		Assert.assertTrue(GEO_LOC_LAT.compareTo(sigFoxMessageList.get(0).getGeolocLat()) == 0);
		Assert.assertTrue(GEO_LOC_LONG.compareTo(sigFoxMessageList.get(0).getGeolocLon()) == 0);
		Assert.assertTrue(GEO_LOC_RADIUS.compareTo(sigFoxMessageList.get(0).getGeolocRadius()) == 0);
	}

	/**
	 * Test obtener todos los mensajes: Devuelve una lista vacia con un elemento
	 * previamente insertado y su contenido es el esperado
	 */

	@Test
	public void testFindAllEmpty() {

		List<SigfoxMessage> sigFoxMessageList = sigfoxMessageService.findAll();

		Assert.assertNotNull(sigFoxMessageList);
		Assert.assertEquals(0, sigFoxMessageList.size());

	}

	/**
	 * Test obtener mensaje: Obtiene un mensaje por id, devuelve null al no
	 * haber ningun mensaje en DB
	 */
	@Test
	@Sql({ "classpath:insertSigFoxMessage.sql" })
	public void testFindByIdNull() {

		Long longNotInserted = 10L;

		Optional<SigfoxMessage> sf = sigfoxMessageService.findById(longNotInserted);

		if (!sf.isPresent()) {
			SigfoxMessage sigFoxMessage = null;
			Assert.assertNull(sigFoxMessage);
		} else {

			SigfoxMessage sigFoxMessage = sf.get();
			Assert.assertNull(sigFoxMessage);
		}

	}

	/**
	 * Test obtener mensaje: Obtiene un mensaje por id, devuelve el objeto que
	 * se ha insertado previamente
	 */

	@Test
	@Sql({ "classpath:insertSigFoxMessage.sql" })
	public void testFindById() {

		Optional<SigfoxMessage> sf = sigfoxMessageService.findById(1L);

		SigfoxMessage sigFoxMessage = sf.get();

		Assert.assertNotNull(sigFoxMessage);
		Assert.assertTrue(sigFoxMessage.getId().compareTo(1L) == 0);
		Assert.assertEquals(DEVICE_ID, sigFoxMessage.getDeviceId());
		Assert.assertEquals(MESSAGE_DATE, sigFoxMessage.getMessageDate());
		Assert.assertEquals(SEQ_NUMBER, sigFoxMessage.getSeqnumer());
		Assert.assertTrue(RECEPTION_ID.compareTo(sigFoxMessage.getReceptionId()) == 0);
		Assert.assertTrue(RECEPTION_SSI.compareTo(sigFoxMessage.getReceptionRssi()) == 0);
		Assert.assertTrue(RECEPTION_SNR.compareTo(sigFoxMessage.getReceptionSnr()) == 0);
		Assert.assertTrue(GEO_LOC_LAT.compareTo(sigFoxMessage.getGeolocLat()) == 0);
		Assert.assertTrue(GEO_LOC_LONG.compareTo(sigFoxMessage.getGeolocLon()) == 0);
		Assert.assertTrue(GEO_LOC_RADIUS.compareTo(sigFoxMessage.getGeolocRadius()) == 0);

	}

}
