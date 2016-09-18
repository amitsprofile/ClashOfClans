package com.aptmgmt.dao;

import java.util.List;

import com.aptmgmt.model.Building;
import com.aptmgmt.model.Society;

public interface BuildingDAO {

	public void persist(Building transientInstance);

	public void remove(Building persistentInstance);

	public Building save(Building detachedInstance);

	public Building findById(Integer id);
	
	public List<Building> findAll();
	
	public Building find(String buildingName);
	
	public Building findByUniqueKey(Society society, String buildingId);
	
}
