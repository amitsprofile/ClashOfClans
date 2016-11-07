package com.aptmgmt.dao.user;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.dao.JpaDao;
import com.aptmgmt.entity.User;

@Repository
@Stateless
public class UserDAOImpl extends JpaDao<User, Long> implements UserDAO {
	private static final Log log = LogFactory.getLog(UserDAO.class);
	
	public UserDAOImpl()
    {
        super(User.class);
    }

	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			this.getEntityManager().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(User persistentInstance) {
		log.debug("removing User instance");
		try {
			this.getEntityManager().remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = this.getEntityManager().merge(detachedInstance);
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
			User instance = this.getEntityManager().find(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public User findByUsername(String username) {
		String hql = "SELECT hs FROM User hs WHERE hs.username=:username";
		TypedQuery<User> query = this.getEntityManager().createQuery(hql, User.class);
		query.setParameter("username", username);
		User instance = query.getSingleResult();
		return instance;
	}
	
	public Integer findMaxId(){
		String hql = "SELECT MAX(u.id) as maxId from User u";
		TypedQuery<Integer> query = this.getEntityManager().createQuery(hql, Integer.class);
		return query.getSingleResult();
	}
}
