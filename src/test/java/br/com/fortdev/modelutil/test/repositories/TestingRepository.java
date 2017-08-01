package br.com.fortdev.modelutil.test.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fortdev.modelutil.repositories.impl.GenericRepositoryImpl;
import br.com.fortdev.modelutil.test.domains.TestingEntity;

/**
 * Test repository.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
@Repository
public class TestingRepository extends GenericRepositoryImpl<TestingEntity, Long> {

	private static final long serialVersionUID = 4575959798206651226L;

	private boolean config = false;

	@Transactional
	public void setup() {
		if (!config) {
			for (int i = 0; i < 5; i++) {
				TestingEntity object = new TestingEntity();
				object.setDescription("My Test " + (i + 1) + "!");
				save(object);
			}
			config = true;
		}
	}

}
