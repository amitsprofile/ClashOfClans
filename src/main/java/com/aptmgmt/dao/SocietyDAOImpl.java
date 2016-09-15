package com.aptmgmt.dao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.model.Society;

/**
 * DAO object for domain model class Society.
 * @see com.aptmgmt.model.Society
 * @author Prakash Manwani
 */

@Repository
@Stateless
public class SocietyDAOImpl implements SocietyDAO {

	private static final Log log = LogFactory.getLog(SocietyDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Society transientInstance) {
		log.debug("persisting Society instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Society persistentInstance) {
		log.debug("removing Society instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Society merge(Society detachedInstance) {
		log.debug("merging Society instance");
		try {
			Society result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Society findById(Integer id) {
		log.debug("getting Society instance with id: " + id);
		try {
			Society instance = entityManager.find(Society.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
