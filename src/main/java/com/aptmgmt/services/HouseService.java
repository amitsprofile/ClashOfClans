package com.aptmgmt.services;

import java.util.List;

import com.aptmgmt.model.House;

public interface HouseService {

	public House addHouse(House house);
	
	public void addAllHouse(List<House> houses);
	
	public List<House> listAllHouse();
	
	public House findByHouseNumber(String houseNumber);
	
}
