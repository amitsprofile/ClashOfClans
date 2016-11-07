package com.aptmgmt.services;

import java.util.UUID;

import javax.ws.rs.WebApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptmgmt.dao.accesstoken.AccessTokenDAO;
import com.aptmgmt.dao.user.UserDAO;
import com.aptmgmt.dao.userinfo.UserInfoDAO;
import com.aptmgmt.entity.AccessToken;
import com.aptmgmt.entity.User;
import com.aptmgmt.model.UserCredential;
import com.aptmgmt.utils.EntityMapper;
import com.aptmgmt.utils.ModelMapper;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	private UserDAO userDao;

	private AccessTokenDAO accessTokenDao;
	
	private UserInfoDAO userInfoDao;
	
	private EntityMapper entityMapper;
	
	private ModelMapper modelMapper;
	
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;

	@Override
	@Transactional(readOnly = true)
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = (User) userDao.findByUsername(username);
		return user;
	}

	@Override
	@Transactional
	public User findUserByAccessToken(String accessTokenString) {
		AccessToken accessToken = this.accessTokenDao.findByToken(accessTokenString);

		if (null == accessToken) {
			return null;
		}

		if (accessToken.isExpired()) {
			this.accessTokenDao.delete(accessToken);
			return null;
		}

		return accessToken.getUser();
	}

	@Override
	@Transactional
	public AccessToken createAccessToken(User user) {
		AccessToken accessToken = new AccessToken(user, UUID.randomUUID().toString());
		return this.accessTokenDao.save(accessToken);
	}
	
	@Transactional
	public Integer getMaxId(){
		return userDao.findMaxId();
	}
	
	@Override
	public com.aptmgmt.model.AccessToken saveUser(com.aptmgmt.model.User user) {
		com.aptmgmt.entity.User us = entityMapper.map(user, null);
		us.setUserInfo(userInfoDao.save(us.getUserInfo()));
		UserCredential cred = new UserCredential(user.getUsername(), user.getPassword());
		return authenticate(cred);
	}

	public com.aptmgmt.model.AccessToken authenticate(UserCredential userCred) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userCred.getUsername(), userCred.getPassword());
		Authentication authentication = authManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Object principal = authentication.getPrincipal();
		if (!(principal instanceof User)) {
			throw new WebApplicationException(401);
		}

		AccessToken at = createAccessToken((User) principal);
		com.aptmgmt.model.AccessToken res = new com.aptmgmt.model.AccessToken(at.getToken(),
				modelMapper.map(at.getUser()));
		return res;
	}
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public void setAccessTokenDao(AccessTokenDAO accessTokenDao) {
		this.accessTokenDao = accessTokenDao;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public AccessTokenDAO getAccessTokenDao() {
		return accessTokenDao;
	}

	public UserInfoDAO getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDAO userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public EntityMapper getEntityMapper() {
		return entityMapper;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setEntityMapper(EntityMapper entityMapper) {
		this.entityMapper = entityMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	

}