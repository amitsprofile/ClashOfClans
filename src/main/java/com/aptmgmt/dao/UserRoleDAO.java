package com.aptmgmt.dao;

import com.aptmgmt.model.UserRole;

public interface UserRoleDAO {

	public void persist(UserRole transientInstance);

	public void remove(UserRole persistentInstance);

	public UserRole merge(UserRole detachedInstance);

	public UserRole findById(Integer id);
}
