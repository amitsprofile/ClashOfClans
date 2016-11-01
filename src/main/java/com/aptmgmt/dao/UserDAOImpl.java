package com.aptmgmt.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.aptmgmt.model.User;

@Repository
@Stateless
public class UserDAOImpl implements UserDAO {
	private static final Log log = LogFactory.getLog(UserDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(User persistentInstance) {
		log.debug("removing User instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			detachedInstance.setPassword(new BCryptPasswordEncoder().encode(detachedInstance.getPassword()));
			User result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(String id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = entityManager.find(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public User findByUsername(String username) {
		String hql = "SELECT hs FROM User hs WHERE hs.username=:username";
		TypedQuery<User> query = this.entityManager.createQuery(hql, User.class);
		query.setParameter("username", username);
		User instance = query.getSingleResult();
		return instance;
	}
}
