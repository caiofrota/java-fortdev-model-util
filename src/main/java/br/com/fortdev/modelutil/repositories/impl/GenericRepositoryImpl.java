package br.com.fortdev.modelutil.repositories.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.fortdev.modelutil.domains.GenericEntity;
import br.com.fortdev.modelutil.exceptions.EntityNullException;
import br.com.fortdev.modelutil.exceptions.PrimaryKeyNullException;
import br.com.fortdev.modelutil.repositories.GenericRepository;

/**
 * Generic repository.
 * 
 * @author Caio Frota (contato@caiofrota.com.br)
 * @version 1.0
 * @since 1.0
 * 
 * @param <E>
 *            Entity.
 * @param <PK>
 *            Primary key.
 */
@Transactional(propagation = Propagation.SUPPORTS)
public class GenericRepositoryImpl<E extends GenericEntity<PK>, PK extends Serializable>
		implements GenericRepository<E, PK> {

	private static final long serialVersionUID = 8496006039538789900L;

	@PersistenceContext
	private EntityManager entityManager;

	protected Class<E> persistentClass;

	protected final Logger logger = Logger.getLogger(GenericRepository.class);

	@SuppressWarnings("unchecked")
	public GenericRepositoryImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		Type[] args = parameterizedType.getActualTypeArguments();
		persistentClass = (Class<E>) args[0];
	}

	/**
	 * Persist a object.
	 * 
	 * @param obj
	 *            Object to persist.
	 */
	@Transactional
	public void save(E obj) {
		if (obj == null) {
			throw new EntityNullException();
		}
		logger.info("Method save with param = [".concat(obj.toString()).concat("]."));
		entityManager.persist(obj);
	}

	/**
	 * Update a object or insert if doesn't exist.
	 * 
	 * @param obj
	 *            Object to update.
	 */
	@Transactional
	public void update(E obj) {
		if (obj == null) {
			throw new EntityNullException();
		}
		logger.info("Method update with param = [".concat(obj.toString()).concat("]."));
		entityManager.merge(obj);
	}

	/**
	 * Find a object by primary key.
	 * 
	 * @param primaryKey
	 *            Primary key.
	 * @return Object.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public E findByPrimaryKey(PK primaryKey) {
		if (primaryKey == null) {
			throw new PrimaryKeyNullException();
		}
		logger.info("Method findBy");
		return (E) getSession().get(persistentClass, primaryKey);
	}

	/**
	 * Find a object by primary key.
	 * 
	 * @return List of objects.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> findAll() {
		logger.info("Method findBy");
		return getSession().createCriteria(persistentClass).list();
	}

	/**
	 * Find a object by criterias.
	 * 
	 * @return List of objects.
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> findByCriteria(Criterion... criterias) {
		Criteria criteria = getSession().createCriteria(persistentClass);
		if (criterias != null) {
			for (Criterion currentCriteria : criterias) {
				criteria.add(currentCriteria);
			}
		}
		return criteria.list();
	}

	/**
	 * Remove a object.
	 * 
	 * @param obj
	 *            Object to remove.
	 */
	@Transactional
	public void delete(E obj) {
		if (obj == null) {
			throw new EntityNullException();
		}
		logger.info("Method delete with param = [".concat(obj.toString()).concat("]."));
		entityManager.remove(entityManager.getReference(this.persistentClass, obj.getId()));
	}

	/**
	 * Get the session.
	 * 
	 * @return Session.
	 */
	@Transactional
	public Session getSession() {
		return (Session) entityManager.getDelegate();
	}
}
