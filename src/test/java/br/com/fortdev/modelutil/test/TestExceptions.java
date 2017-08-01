package br.com.fortdev.modelutil.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.fortdev.modelutil.bundle.ModelBundle;
import br.com.fortdev.modelutil.exceptions.GenericModelException;
import br.com.fortdev.modelutil.exceptions.ModelExceptionLevel;

/**
 * Test Exceptions.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
@ContextConfiguration(locations = { "classpath:spring-context.xml", "classpath:spring-data.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestExceptions {

	/**
	 * Test cases.
	 */

	@Autowired
	private ModelBundle bundle;

	// -----

	@Test
	public void genericExpcetionConstructorDefault() {
		GenericModelException exp = new GenericModelException();

		assertNull(exp.getLevel());
		assertNull(exp.getMessage());
		assertNull(exp.getParams());
	}

	@Test
	public void genericExpcetionConstructorWith2Params() {
		ModelExceptionLevel level = ModelExceptionLevel.INFO;
		String message = "My Message";
		GenericModelException exp = new GenericModelException(level, message);

		assertEquals(exp.getLevel().getLevel(), level.getLevel());
		assertEquals(exp.getMessage(), message);
		assertNull(exp.getParams());
	}

	@Test
	public void genericExpcetionConstructorWith3Params() {
		ModelExceptionLevel level = ModelExceptionLevel.INFO;
		String message = "My Message";
		Object params = new Object[] {};
		GenericModelException exp = new GenericModelException(level, message, params);

		assertEquals(exp.getLevel().getLevel(), level.getLevel());
		assertEquals(exp.getMessage(), message);
		assertEquals(exp.getParams()[0], params);
	}

	@Test
	public void genericExceptionModelBundleShouldBeTranslated() {
		String key = "TEST";

		GenericModelException exp = new GenericModelException(ModelExceptionLevel.INFO, key);

		assertEquals(exp.getMessage(bundle), bundle.message(key));
	}

	@Test
	public void genericExceptionModelBundleNonExistingShouldNotBeTranslated() {
		String key = "TEST_FAIL";

		GenericModelException exp = new GenericModelException(ModelExceptionLevel.INFO, key);

		assertEquals(exp.getMessage(bundle), key);
	}

	// -----

}
