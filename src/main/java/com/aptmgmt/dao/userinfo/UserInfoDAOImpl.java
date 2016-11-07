package com.aptmgmt.dao.userinfo;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.aptmgmt.dao.JpaDao;
import com.aptmgmt.entity.UserInfo;

@Repository
@Stateless
public class UserInfoDAOImpl extends JpaDao<UserInfo, Long> implements UserInfoDAO {
	private static final Log log = LogFactory.getLog(UserInfoDAO.class);
	
	public UserInfoDAOImpl()
    {
        super(UserInfo.class);
    }

	public void persist(UserInfo transientInstance) {
		log.debug("persisting UserInfo instance");
		try {
			this.getEntityManager().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserInfo persistentInstance) {
		log.debug("removing UserInfo instance");
		try {
			this.getEntityManager().remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserInfo merge(UserInfo detachedInstance) {
		log.debug("merging UserInfo instance");
		try {
			UserInfo result = this.getEntityManager().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserInfo findById(Integer id) {
		log.debug("getting UserInfo instance with id: " + id);
		try {
			UserInfo instance = this.getEntityManager().find(UserInfo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public UserInfo findByEmail(String email) {
		String hql = "SELECT usinf FROM UserInfo usinf WHERE usinf.email=:email";
		TypedQuery<UserInfo> query = this.getEntityManager().createQuery(hql, UserInfo.class);
		query.setParameter("email", email);
		UserInfo instance = query.getSingleResult();
		return instance;
	}
	
	public Integer findMaxId(){
		String hql = "SELECT MAX(ui.id) as maxId from UserInfo ui";
		TypedQuery<Integer> query = this.getEntityManager().createQuery(hql, Integer.class);
		return query.getSingleResult();
	}
}
