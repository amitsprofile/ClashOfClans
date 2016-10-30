package com.aptmgmt.dao;

import com.aptmgmt.model.UserRoles;

public interface UserRolesDAO {

	public void persist(UserRoles transientInstance);

	public void remove(UserRoles persistentInstance);

	public UserRoles merge(UserRoles detachedInstance);

	public UserRoles findById(Integer id);
}
