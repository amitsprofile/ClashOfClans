package com.aptmgmt.dao.userrole;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.dao.JpaDao;
import com.aptmgmt.entity.UserRole;

@Repository
@Stateless
public class UserRoleDAOImpl extends JpaDao<UserRole, Long> implements UserRoleDAO {
	private static final Log log = LogFactory.getLog(UserRoleDAO.class);

	public UserRoleDAOImpl() {
		super(UserRole.class);
	}

	public void persist(UserRole transientInstance) {
		log.debug("persisting UserRole instance");
		try {
			this.getEntityManager().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserRole persistentInstance) {
		log.debug("removing UserRole instance");
		try {
			this.getEntityManager().remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserRole merge(UserRole detachedInstance) {
		log.debug("merging UserRole instance");
		try {
			UserRole result = this.getEntityManager().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserRole findById(Integer id) {
		log.debug("getting UserRole instance with id: " + id);
		try {
			UserRole instance = this.getEntityManager().find(UserRole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Integer findMaxId() {
		String hql = "SELECT MAX(ur.userRoleId) as maxId from UserRole ur";
		TypedQuery<Integer> query = this.getEntityManager().createQuery(hql, Integer.class);
		return query.getSingleResult();
	}

}
