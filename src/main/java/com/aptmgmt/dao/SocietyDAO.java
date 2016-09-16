package com.aptmgmt.dao;

import java.util.List;

import com.aptmgmt.model.Society;

public interface SocietyDAO {
	
	public void persist(Society transientInstance);

	public void remove(Society persistentInstance);

	public Society merge(Society detachedInstance);

	public Society findById(Integer id);
	
	public List<Society> findAll();
	
	public Society findByUniqueKey(String societyName);
	
}
