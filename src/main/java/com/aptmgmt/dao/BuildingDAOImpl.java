package com.aptmgmt.dao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.model.Building;

/**
 * DAO object for domain model class Building.
 * @see com.aptmgmt.model.Building
 * @author Prakash Manwani
 */

@Repository
@Stateless
public class BuildingDAOImpl implements BuildingDAO {

	private static final Log log = LogFactory.getLog(BuildingDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Building transientInstance) {
		log.debug("persisting Building instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Building persistentInstance) {
		log.debug("removing Building instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Building merge(Building detachedInstance) {
		log.debug("merging Building instance");
		try {
			Building result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Building findById(Integer id) {
		log.debug("getting Building instance with id: " + id);
		try {
			Building instance = entityManager.find(Building.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
