package com.aptmgmt.dao.userrole;

import com.aptmgmt.dao.Dao;
import com.aptmgmt.entity.UserRole;

public interface UserRoleDAO  extends Dao<UserRole, Long> {

	public void persist(UserRole transientInstance);

	public void remove(UserRole persistentInstance);

	public UserRole merge(UserRole detachedInstance);

	public UserRole findById(Integer id);
	
	public Integer findMaxId();
}
