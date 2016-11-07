package com.aptmgmt.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.aptmgmt.entity.AccessToken;
import com.aptmgmt.entity.User;
import com.aptmgmt.model.UserCredential;


public interface UserDetailService  extends UserDetailsService{
	
	 public User loadUserByUsername(String userId);
	 
	 public User findUserByAccessToken(String accessToken);

	 public AccessToken createAccessToken(User user);
	 
	 public com.aptmgmt.model.AccessToken saveUser(com.aptmgmt.model.User user);
	 
	 public com.aptmgmt.model.AccessToken authenticate(UserCredential userCred);
	 
	 public Integer getMaxId();
	 
}
