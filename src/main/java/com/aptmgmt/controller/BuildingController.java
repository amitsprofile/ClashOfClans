package com.aptmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aptmgmt.model.Building;
import com.aptmgmt.services.BuildingService;

@Controller
@RequestMapping("/building/")
public class BuildingController {

	@Autowired
	private BuildingService buildingService;
	
	@RequestMapping(value = "addbuilding", method = RequestMethod.POST)
	public @ResponseBody Building addBuilding(@RequestParam(value="building") Building building) {
		return buildingService.addBuilding(building);
	}
	
	@RequestMapping(value = "getallbuildings", method = RequestMethod.GET)
	public @ResponseBody List<Building> getAllHouses() {
		return buildingService.listAllBuilding();
	}
}
