package br.com.fortdev.modelutil.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.fortdev.modelutil.exceptions.EntityNullException;
import br.com.fortdev.modelutil.exceptions.PrimaryKeyNullException;
import br.com.fortdev.modelutil.test.domains.TestingEntity;
import br.com.fortdev.modelutil.test.repositories.TestingRepository;

/**
 * Test GenericRepository.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
@ContextConfiguration(locations = { "classpath:spring-context.xml", "classpath:spring-data.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestGenericRepository {

	@Autowired
	private TestingRepository repository;

	/**
	 * Find object by primary key.
	 * 
	 * @param primaryKey
	 *            Primary key.
	 * @return List of objects.
	 */
	public List<TestingEntity> findAll() {
		repository.setup();
		return repository.findAll();
	}

	/**
	 * Find object by primary key.
	 * 
	 * @param primaryKey
	 *            Primary key.
	 * @return Object.
	 */
	public TestingEntity findByPrimaryKey(Long primaryKey) {
		repository.setup();
		return repository.findByPrimaryKey(primaryKey);
	}

	/**
	 * Find object by primary key.
	 * 
	 * @param primaryKey
	 *            Primary key.
	 * @return Object.
	 */
	public List<TestingEntity> findByCriteria(Criterion... criterias) {
		repository.setup();
		return repository.findByCriteria(criterias);
	}

	/**
	 * Save object.
	 * 
	 * @param object
	 *            Object to save.
	 */
	public void save(TestingEntity object) {
		repository.setup();
		repository.save(object);
	}

	/**
	 * Update object.
	 * 
	 * @param object
	 *            Object to update.
	 */
	public void update(TestingEntity object) {
		repository.setup();
		repository.update(object);
	}

	/**
	 * Delete object.
	 * 
	 * @param object
	 *            Object to delete.
	 */
	public void delete(TestingEntity object) {
		repository.setup();
		repository.delete(object);
	}

	/**
	 * Test cases.
	 */

	// -----

	@Test // findAll
	public void findAllShouldReturnNotNull() {
		List<TestingEntity> list = findAll();
		assertNotNull(list);
	}

	@Test // findByPrimaryKey
	public void findByPrimaryKeyExistingShouldReturnObject() {
		TestingEntity object = findByPrimaryKey(1l);
		assertNotNull(object);
	}

	@Test // findByPrimaryKey
	public void findByPrimaryKeyNonExistingShouldReturnNull() {
		TestingEntity object = findByPrimaryKey(-1l);
		assertNull(object);
	}

	@Test(expected = PrimaryKeyNullException.class) // findByPrimaryKey
	public void findByPrimaryKeyNullShouldReturnNull() {
		findByPrimaryKey(null);
	}

	@Test // findByCriteria
	public void findByCriteriaShouldReturnNotNull() {
		Criterion criteria = Restrictions.eq("description", "My Test 1!");
		List<TestingEntity> list = findByCriteria(criteria);
		assertNotNull(list);
	}

	@Test // findByCriteria
	public void findByCriteriaNullShouldReturnNotNull() {
		List<TestingEntity> list = findByCriteria(null);
		assertNotNull(list);
	}

	@Test // save
	public void saveObjectShouldBeSaved() {
		String description = "My Test Case saveObjectShouldBeSaved!";
		TestingEntity object = new TestingEntity();
		object.setDescription(description);
		save(object);

		Criterion criteria = Restrictions.eq("description", description);
		List<TestingEntity> list = findByCriteria(criteria);
		assertEquals(list.size(), 1);
	}

	@Test(expected = EntityNullException.class) // save
	public void saveNullShouldThrowException() {
		save(null);
	}

	@Test // update
	public void updateObjectSholdBeUpdated() {
		String description = "My Test Updated!";
		TestingEntity object = new TestingEntity();
		object.setId(2l);
		object.setDescription(description);
		update(object);

		Criterion criteria = Restrictions.eq("description", description);
		List<TestingEntity> list = findByCriteria(criteria);
		assertEquals(list.size(), 1);
	}

	@Test(expected = EntityNullException.class) // update
	public void updateNullShouldThrowException() {
		update(null);
	}

	@Test // delete
	public void deleteObjectSholdBeUpdated() {
		TestingEntity object = new TestingEntity();
		object.setId(3l);
		delete(object);

		assertNull(findByPrimaryKey(3l));
	}

	@Test(expected = EntityNullException.class) // delete
	public void deleteNullShouldThrowException() {
		delete(null);
	}

	// -----

}
