package com.aptmgmt.dao.house;

import java.util.List;

import com.aptmgmt.dao.Dao;
import com.aptmgmt.entity.Building;
import com.aptmgmt.entity.House;
import com.aptmgmt.entity.Society;

public interface HouseDAO  extends Dao<House, Long> {

	public void persist(House transientInstance);

	public void remove(House persistentInstance);

	public House save(House detachedInstance);

	public House findById(Integer id);
	
	public List<House> findAll();
	
	public House find(String houseNumber);
	
	public House findByUniqueKey(Society society, Building building, String houseNumber);
	
	public House findByUserId(Integer userId);
	
	public Integer findMaxId();
	
}
