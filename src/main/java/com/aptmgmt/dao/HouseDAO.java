package com.aptmgmt.dao;

import java.util.List;

import com.aptmgmt.model.Building;
import com.aptmgmt.model.House;
import com.aptmgmt.model.Society;

public interface HouseDAO {

	public void persist(House transientInstance);

	public void remove(House persistentInstance);

	public House save(House detachedInstance);

	public House findById(Integer id);
	
	public List<House> findAll();
	
	public House find(String houseNumber);
	
	public House findByUniqueKey(Society society, Building building, String houseNumber);
	
}
