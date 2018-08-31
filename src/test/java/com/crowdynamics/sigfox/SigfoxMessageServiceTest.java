package com.crowdynamics.sigfox;

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
    	
    	List<SigfoxMessage> sigFoxMessageList = sigFoxMessageList=sigfoxMessageService.findAll();
    	
    	Assert.assertNotNull(sigFoxMessageList);
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
