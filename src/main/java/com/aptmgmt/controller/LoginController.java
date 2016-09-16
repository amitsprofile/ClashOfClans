package com.aptmgmt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aptmgmt.services.BuildingService;
import com.aptmgmt.services.HouseService;
import com.aptmgmt.services.SocietyService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired private SocietyService societyService;
	@Autowired private BuildingService buildingService;
	@Autowired private HouseService houseService;
	
	@RequestMapping("SocietyBuildingHouses")
	public Map<String, Object> getSocietyBuildingHouses() {
		Map<String, Object> models = new HashMap<String, Object>();
		models.put("societies", societyService.listAllSociety());
		models.put("buildings", buildingService.listAllBuilding());
		models.put("houses", houseService.listAllHouse());
		return models;
	}
}
