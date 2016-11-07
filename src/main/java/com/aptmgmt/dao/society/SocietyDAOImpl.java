package com.aptmgmt.dao.society;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.dao.JpaDao;
import com.aptmgmt.entity.Society;

/**
 * DAO object for domain model class Society.
 * 
 * @see com.aptmgmt.entity.Society
 * @author Prakash Manwani
 */

@Repository
@Stateless
public class SocietyDAOImpl extends JpaDao<Society, Long> implements SocietyDAO {

	private static final Log log = LogFactory.getLog(SocietyDAOImpl.class);

	public SocietyDAOImpl() {
		super(Society.class);
	}

	@Override
	public void persist(Society transientInstance) {
		log.debug("persisting Society instance");
		try {
			this.getEntityManager().persist(transientInstance);
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
			this.getEntityManager().remove(persistentInstance);
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
			Society result = this.getEntityManager().merge(detachedInstance);
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
			Society instance = this.getEntityManager().find(Society.class, id);
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
		TypedQuery<Society> query = this.getEntityManager().createQuery(hql, Society.class);
		return query.getResultList();
	}

	@Override
	public Society findByUniqueKey(String societyName) {
		String hql = "SELECT sc FROM Society sc WHERE sc.name=:societyName";
		TypedQuery<Society> query = this.getEntityManager().createQuery(hql, Society.class);
		query.setParameter("societyName", societyName);
		Society instance = query.getSingleResult();
		return instance;
	}

	public Integer findMaxId() {
		String hql = "SELECT MAX(sc.id) as maxId from Society sc";
		TypedQuery<Integer> query = this.getEntityManager().createQuery(hql, Integer.class);
		return query.getSingleResult();
	}
}
