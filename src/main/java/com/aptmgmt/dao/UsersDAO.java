package com.aptmgmt.dao;

import com.aptmgmt.model.Users;

public interface UsersDAO {

	public void persist(Users transientInstance);

	public void remove(Users persistentInstance);

	public Users merge(Users detachedInstance);

	public Users findById(String id);

	public Users findByUsername(String username);
}
