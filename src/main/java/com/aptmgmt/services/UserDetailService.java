package com.aptmgmt.services;

import com.aptmgmt.model.Users;

public interface UserDetailService {
	
	 public Users loadUserByUsername(String userId);
}
