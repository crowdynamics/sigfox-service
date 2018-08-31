package com.crowdynamics.sigfox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SigfoxMessageServiceTest {

    @Autowired
    private SigfoxMessageService sigfoxMessageService;
	
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
