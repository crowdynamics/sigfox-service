package com.crowdynamics.sigfox;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.crowdynamics.sigfox.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SigfoxApplicationTest {
	
	@Autowired
	private SigFoxMessageService SIGFOXMESSAGESERVICE;
	
	@Test
	public void contextStarts()	{
	}
}
