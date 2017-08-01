package br.com.fortdev.modelutil.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.fortdev.modelutil.bundle.ModelBundle;

/**
 * Test ModelBundle.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestModelBundle {

	@Autowired
	protected ModelBundle resourceBundle;

	@Test
	public void findMessageShouldBeOk() {
		resourceBundle.message("TEST");
	}

}
