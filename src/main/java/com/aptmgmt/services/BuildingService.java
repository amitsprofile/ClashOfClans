package com.aptmgmt.services;

import java.util.List;

import com.aptmgmt.model.Building;

public interface BuildingService {
	
	public Building addBuilding(Building building);
	
	public void addAllBuilding(List<Building> buildings);
	
	public List<Building> listAllBuilding();
	
	public Building findByBuildingName(String buildingName);

}
