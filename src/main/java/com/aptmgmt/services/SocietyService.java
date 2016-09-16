package com.aptmgmt.services;

import java.util.List;

import com.aptmgmt.model.Society;

public interface SocietyService {

	public Society addSociety(Society society);
	
	public void addAllSociety(List<Society> societies);
	
	public List<Society> listAllSociety();
	
	public Society findBySocietyName(String societyName);
	
}
