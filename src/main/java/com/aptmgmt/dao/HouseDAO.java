package com.aptmgmt.dao;

import com.aptmgmt.model.House;

public interface HouseDAO {

	public void persist(House transientInstance);

	public void remove(House persistentInstance);

	public House merge(House detachedInstance);

	public House findById(Integer id);
	
}
