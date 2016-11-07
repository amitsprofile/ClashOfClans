package com.aptmgmt.dao.building;

import java.util.List;

import com.aptmgmt.dao.Dao;
import com.aptmgmt.entity.Building;
import com.aptmgmt.entity.Society;

public interface BuildingDAO extends Dao<Building, Long> {

	public void persist(Building transientInstance);

	public void remove(Building persistentInstance);

	public Building save(Building detachedInstance);

	public Building findById(Integer id);
	
	public List<Building> findAll();
	
	public Building find(String buildingName);
	
	public Building findByUniqueKey(Society society, String buildingId);
	
	public Integer findMaxId();
	
}
