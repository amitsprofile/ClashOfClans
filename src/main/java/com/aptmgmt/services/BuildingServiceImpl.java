package com.aptmgmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptmgmt.dao.BuildingDAO;
import com.aptmgmt.model.Building;

@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingDAO buildingDao;
	
	@Transactional
	public Building addBuilding(Building building){
		buildingDao.persist(building);
		return buildingDao.findByUniqueKey(building.getSociety(), building.getBuildingid());
	}
	
	@Transactional
	public void addAllBuilding(List<Building> buildings){
		for (Building building : buildings){
			buildingDao.persist(building);
		}
	}
	
	@Transactional
	public List<Building> listAllBuilding(){
		return buildingDao.findAll();
	}
	
	@Transactional
	public Building findByBuildingName(String buildingName){
		return buildingDao.find(buildingName);
	}

}
