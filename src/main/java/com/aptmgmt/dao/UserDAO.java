package com.aptmgmt.dao;

import com.aptmgmt.model.User;

public interface UserDAO {

	public void persist(User transientInstance);

	public void remove(User persistentInstance);

	public User merge(User detachedInstance);

	public User findById(String id);

	public User findByUsername(String username);
}
