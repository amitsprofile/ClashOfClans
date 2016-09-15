package com.aptmgmt.dao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aptmgmt.model.House;

/**
 * DAO object for domain model class House.
 * @see com.aptmgmt.model.House
 * @author Prakash Manwani
 */
@Stateless
public class HouseDAO {

	private static final Log log = LogFactory.getLog(HouseDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(House transientInstance) {
		log.debug("persisting House instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(House persistentInstance) {
		log.debug("removing House instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public House merge(House detachedInstance) {
		log.debug("merging House instance");
		try {
			House result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public House findById(Integer id) {
		log.debug("getting House instance with id: " + id);
		try {
			House instance = entityManager.find(House.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
