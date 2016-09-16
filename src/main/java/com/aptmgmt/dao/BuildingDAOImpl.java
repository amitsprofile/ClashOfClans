package com.aptmgmt.dao;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.model.Building;
import com.aptmgmt.model.Society;

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
	
	@SuppressWarnings("unchecked")
	public List<Building> findAll() {
		return entityManager.createQuery("SELECT b FROM Building b").getResultList();
	}
	
	public Building find(String buildingName) {
		Query query = entityManager.createNativeQuery("SELECT bd FROM Building bd WHERE bd.name=:buildingName");
		query.setParameter("buildingName", buildingName);
		Building instance = (Building) query.getSingleResult();
		return instance;
	}
	
	public Building findByUniqueKey(Society society, String buildingId) {
		Query query = entityManager.createNativeQuery("SELECT bd FROM Building bd WHERE bd.socid=:societyId AND bd.buildingid=:buildingId");
		query.setParameter("societyId", society.getId());
		query.setParameter("buildingId", buildingId);
		Building instance = (Building) query.getSingleResult();
		return instance;
	}

	
}
	
