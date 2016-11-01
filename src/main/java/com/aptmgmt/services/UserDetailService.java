package com.aptmgmt.services;

import com.aptmgmt.model.User;

public interface UserDetailService {
	
	 public User loadUserByUsername(String userId);
}
