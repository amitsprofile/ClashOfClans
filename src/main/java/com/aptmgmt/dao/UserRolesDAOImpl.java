package com.aptmgmt.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.model.UserRoles;

@Repository
@Stateless
public class UserRolesDAOImpl implements UserRolesDAO {
	private static final Log log = LogFactory.getLog(UserRolesDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UserRoles transientInstance) {
		log.debug("persisting UserRoles instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserRoles persistentInstance) {
		log.debug("removing UserRoles instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserRoles merge(UserRoles detachedInstance) {
		log.debug("merging UserRoles instance");
		try {
			UserRoles result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserRoles findById(Integer id) {
		log.debug("getting UserRoles instance with id: " + id);
		try {
			UserRoles instance = entityManager.find(UserRoles.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
