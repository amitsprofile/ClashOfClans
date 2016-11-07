package com.aptmgmt.dao.building;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.dao.JpaDao;
import com.aptmgmt.entity.Building;
import com.aptmgmt.entity.Society;

/**
 * DAO object for domain model class Building.
 * 
 * @see com.aptmgmt.entity.Building
 * @author Prakash Manwani
 */

@Repository
@Stateless
public class BuildingDAOImpl extends JpaDao<Building, Long> implements BuildingDAO {

	private static final Log log = LogFactory.getLog(BuildingDAOImpl.class);

	public BuildingDAOImpl() {
		super(Building.class);
	}

	@Override
	public void persist(Building transientInstance) {
		log.debug("persisting Building instance");
		try {
			this.getEntityManager().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(Building persistentInstance) {
		log.debug("removing Building instance");
		try {
			this.getEntityManager().remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public Building save(Building detachedInstance) {
		log.debug("merging Building instance");
		try {
			Building result = this.getEntityManager().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Building findById(Integer id) {
		log.debug("getting Building instance with id: " + id);
		try {
			Building instance = this.getEntityManager().find(Building.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Building> findAll() {
		String hql = "SELECT b FROM Building b";
		TypedQuery<Building> query = this.getEntityManager().createQuery(hql, Building.class);
		return query.getResultList();
	}

	@Override
	public Building find(String buildingName) {
		String hql = "SELECT bd FROM Building bd WHERE bd.name=:buildingName";
		TypedQuery<Building> query = this.getEntityManager().createQuery(hql, Building.class);
		query.setParameter("buildingName", buildingName);
		Building instance = query.getSingleResult();
		return instance;
	}

	@Override
	public Building findByUniqueKey(Society society, String buildingId) {
		String hql = "SELECT bd FROM Building bd WHERE bd.socid=:societyId AND bd.buildingid=:buildingId";
		TypedQuery<Building> query = this.getEntityManager().createQuery(hql, Building.class);
		query.setParameter("societyId", society.getId());
		query.setParameter("buildingId", buildingId);
		Building instance = query.getSingleResult();
		return instance;
	}

	public Integer findMaxId() {
		String hql = "SELECT MAX(bd.id) as maxId from Building bd";
		TypedQuery<Integer> query = this.getEntityManager().createQuery(hql, Integer.class);
		return query.getSingleResult();
	}
}
