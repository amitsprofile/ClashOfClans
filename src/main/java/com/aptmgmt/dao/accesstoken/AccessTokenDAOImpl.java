package com.aptmgmt.dao.accesstoken;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aptmgmt.dao.JpaDao;
import com.aptmgmt.entity.AccessToken;

@Repository
public class AccessTokenDAOImpl extends JpaDao<AccessToken, Long> implements AccessTokenDAO {
	
	
	public AccessTokenDAOImpl() {
		super(AccessToken.class);
	}

	@Override
	@Transactional(readOnly = true, noRollbackFor = NoResultException.class)
	public AccessToken findByToken(String accessTokenString) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<AccessToken> query = builder.createQuery(this.entityClass);
		Root<AccessToken> root = query.from(this.entityClass);
		query.where(builder.equal(root.get("token"), accessTokenString));

		try {
			return this.getEntityManager().createQuery(query).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
