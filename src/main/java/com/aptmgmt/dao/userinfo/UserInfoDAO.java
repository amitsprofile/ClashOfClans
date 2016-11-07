package com.aptmgmt.dao.userinfo;

import com.aptmgmt.dao.Dao;
import com.aptmgmt.entity.UserInfo;

public interface UserInfoDAO  extends Dao<UserInfo, Long> {

	public void persist(UserInfo transientInstance);

	public void remove(UserInfo persistentInstance);

	public UserInfo merge(UserInfo detachedInstance);

	public UserInfo findById(Integer id);

	public UserInfo findByEmail(String email);
	
	public Integer findMaxId();
}
