package br.com.fortdev.modelutil.test.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.fortdev.modelutil.domains.GenericEntity;

/**
 * Test Entity.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "testing")
public class TestingEntity extends GenericEntity<Long> {

	private static final long serialVersionUID = 5235487085471482822L;

	private String description;

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
