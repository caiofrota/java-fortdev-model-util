package br.com.fortdev.modelutil.domains;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Entity superclass that maps an entity with an id field.
 * 
 * @author Caio Frota <contato@caiofrota.com.br>
 * @version 1.0
 * @since 1.0
 *
 * @param <PK>
 *            Primary Key.
 */
@MappedSuperclass
public abstract class GenericEntity<PK> implements Serializable {

	private static final long serialVersionUID = -1227916441909989607L;

	private PK id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object object) {
		// Checks if the object is null or not of the same type.
		if (object == null || !(object instanceof GenericEntity)) {
			return false;
		}

		// Checks if the objets are identical.
		if (this == object) {
			return true;
		}

		// Checks if the Ids are equals.
		GenericEntity<PK> other = (GenericEntity<PK>) object;
		if (getId() != null && getId().equals(other.getId())) {
			return true;
		}

		// Are not equals.
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id=" + id + "]";
	}
}
