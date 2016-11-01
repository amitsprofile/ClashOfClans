package com.aptmgmt.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.model.Building;
import com.aptmgmt.model.House;
import com.aptmgmt.model.Society;

/**
 * DAO object for domain model class House.
 * 
 * @see com.aptmgmt.model.House
 * @author Prakash Manwani
 */

@Repository
@Stateless
public class HouseDAOImpl implements HouseDAO {

	private static final Log log = LogFactory.getLog(HouseDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
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

	@Override
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

	@Override
	public House save(House detachedInstance) {
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

	@Override
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

	@Override
	public List<House> findAll() {
		String hql = "SELECT h FROM House h";
		TypedQuery<House> query = this.entityManager.createQuery(hql, House.class);
		return query.getResultList();
	}

	@Override
	public House find(String houseNumber) {
		String hql = "SELECT hs FROM House hs WHERE hs.housenum=:houseNumber";
		TypedQuery<House> query = this.entityManager.createQuery(hql, House.class);
		query.setParameter("houseNumber", houseNumber);
		House instance = query.getSingleResult();
		return instance;
	}

	public House findByUserId(Integer userId) {
		String hql = "SELECT hs FROM House hs WHERE hs.userByResidentid.id=:userId or hs.userByOwnerid.id=:userId";
		TypedQuery<House> query = this.entityManager.createQuery(hql, House.class);
		query.setParameter("userId", userId);
		House instance = query.getSingleResult();
		return instance;
	}

	@Override
	public House findByUniqueKey(Society society, Building building, String houseNumber) {
		String hql = "SELECT hs FROM House hs WHERE hs.socid:=socId AND hs.buildingid=:buildingId AND hs.housenum=:houseNumber";
		TypedQuery<House> query = this.entityManager.createQuery(hql, House.class);
		query.setParameter("socId", society.getId());
		query.setParameter("buildingId", building.getId());
		query.setParameter("houseNumber", houseNumber);
		House instance = query.getSingleResult();
		return instance;
	}

}
