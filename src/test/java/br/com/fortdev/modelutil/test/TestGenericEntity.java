package br.com.fortdev.modelutil.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.fortdev.modelutil.domains.GenericEntity;
import br.com.fortdev.modelutil.test.domains.TestingEntity;

/**
 * Test GenericEntity.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
@ContextConfiguration(locations = { "classpath:spring-context.xml", "classpath:spring-data.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestGenericEntity {

	/**
	 * Test cases.
	 */

	// -----

	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void equalsTheDifferentObjectShouldBeFalse() {
		GenericEntity<Long> entity = new TestingEntity();
		assertFalse(entity.equals(new String()));
	}

	@Test
	public void equalsTheSameObjectShouldBeTrue() {
		GenericEntity<Long> entity = new TestingEntity();
		assertTrue(entity.equals(entity));
	}

	@Test
	public void equalsTheSameIdShouldBeTrue() {
		GenericEntity<Long> entity1 = new TestingEntity();
		GenericEntity<Long> entity2 = new TestingEntity();

		entity1.setId(1l);
		entity2.setId(1l);

		assertTrue(entity1.equals(entity2));
	}

	@Test
	public void equalsTheDifferentIdShouldBeFalse() {
		GenericEntity<Long> entity1 = new TestingEntity();
		GenericEntity<Long> entity2 = new TestingEntity();

		entity1.setId(1l);
		entity2.setId(2l);

		assertFalse(entity1.equals(entity2));
	}

	@Test
	public void equalsNullShouldBeFalse() {
		GenericEntity<Long> entity1 = new TestingEntity();

		entity1.setId(1l);

		assertFalse(entity1.equals(null));
	}

	@Test
	public void equalsUnsettedIdShouldBeFalse() {
		GenericEntity<Long> entity1 = new TestingEntity();
		GenericEntity<Long> entity2 = new TestingEntity();

		assertFalse(entity1.equals(entity2));
	}

	@Test
	public void hashCodeWhenObjectChangesShouldBeFalse() {
		GenericEntity<Long> entity = new TestingEntity();

		entity.setId(1l);
		int hashCode1 = entity.hashCode();

		entity.setId(2l);
		int hashCode2 = entity.hashCode();

		assertNotEquals(hashCode1, hashCode2);
	}

	@Test
	public void hashCodeWhenObjectSetsShouldBeFalse() {
		GenericEntity<Long> entity = new TestingEntity();

		int hashCode1 = entity.hashCode();

		entity.setId(1l);
		int hashCode2 = entity.hashCode();

		assertNotEquals(hashCode1, hashCode2);
	}

	// -----

}
