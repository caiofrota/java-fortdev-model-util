package br.com.fortdev.modelutil.test.domains;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.fortdev.modelutil.domains.GenericEntity;

/**
 * Test Generic Entity.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "testing_generic")
public class TestingGenericEntity extends GenericEntity<Long> {

	private static final long serialVersionUID = 5235487085471482822L;

}
