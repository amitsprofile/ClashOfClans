package com.aptmgmt.dao;

import com.aptmgmt.model.Building;

public interface BuildingDAO {

	public void persist(Building transientInstance);

	public void remove(Building persistentInstance);

	public Building merge(Building detachedInstance);

	public Building findById(Integer id);
	
}
