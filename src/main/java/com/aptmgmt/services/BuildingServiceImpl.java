package com.aptmgmt.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptmgmt.dao.building.BuildingDAO;
import com.aptmgmt.entity.Building;

@Service
public class BuildingServiceImpl implements BuildingService {

	private static final Log log = LogFactory.getLog(BuildingServiceImpl.class);

	private BuildingDAO buildingDao;

	@Transactional
	public Building addBuilding(Building building) {
		if (log.isDebugEnabled()) {
			log.debug("Method before persist: addBuilding(Building building)\n");
			log.debug(building);
		}
		buildingDao.persist(building);
		Building instance = buildingDao.findByUniqueKey(building.getSociety(), building.getBuildingid());

		if (log.isDebugEnabled()) {
			log.debug("After persist Building: \n");
			log.debug(instance);
		}
		return instance;
	}

	@Transactional
	public void addAllBuilding(List<Building> buildings) {
		for (Building building : buildings) {
			buildingDao.persist(building);
		}
	}

	@Transactional
	public List<Building> listAllBuilding() {
		return buildingDao.findAll();
	}

	@Transactional
	public Building findByBuildingName(String buildingName) {
		return buildingDao.find(buildingName);
	}

	@Transactional
	public Integer getMaxId() {
		return buildingDao.findMaxId();
	}

	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}

	public static Log getLog() {
		return log;
	}

	public BuildingDAO getBuildingDao() {
		return buildingDao;
	}

}
