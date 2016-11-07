package com.aptmgmt.dao.user;

import com.aptmgmt.dao.Dao;
import com.aptmgmt.entity.User;

public interface UserDAO  extends Dao<User, Long> {

	public void persist(User transientInstance);

	public void remove(User persistentInstance);

	public User merge(User detachedInstance);

	public User findById(String id);

	public User findByUsername(String username);
	
	public Integer findMaxId();
}
