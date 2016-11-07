package com.aptmgmt.dao.society;

import java.util.List;

import com.aptmgmt.dao.Dao;
import com.aptmgmt.entity.Society;

public interface SocietyDAO  extends Dao<Society, Long> {
	
	public void persist(Society transientInstance);

	public void remove(Society persistentInstance);

	public Society save(Society detachedInstance);

	public Society findById(Integer id);
	
	public List<Society> findAll();
	
	public Society findByUniqueKey(String societyName);
	
	public Integer findMaxId();
	
}
