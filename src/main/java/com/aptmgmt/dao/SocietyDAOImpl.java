package com.aptmgmt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.model.Society;

/**
 * DAO object for domain model class Society.
 * 
 * @see com.aptmgmt.model.Society
 * @author Prakash Manwani
 */

@Repository
@Stateless
public class SocietyDAOImpl implements SocietyDAO {

	private static final Log log = LogFactory.getLog(SocietyDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
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

	@Override
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

	@Override
	public Society save(Society detachedInstance) {
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

	@Override
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

	@Override
	public List<Society> findAll() {
		String hql = "SELECT sc FROM Society sc";
		TypedQuery<Society> query = this.entityManager.createQuery(hql, Society.class);
		return query.getResultList();
	}

	@Override
	public Society findByUniqueKey(String societyName) {
		String hql = "SELECT sc FROM Society sc WHERE sc.name=:societyName";
		TypedQuery<Society> query = this.entityManager.createQuery(hql,Society.class);
		query.setParameter("societyName", societyName);
		Society instance = query.getSingleResult();
		return instance;
	}
}
