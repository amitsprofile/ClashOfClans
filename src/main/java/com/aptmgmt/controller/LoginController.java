package com.aptmgmt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aptmgmt.services.BuildingService;
import com.aptmgmt.services.HouseService;
import com.aptmgmt.services.SocietyService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired private SocietyService societyService;
	@Autowired private BuildingService buildingService;
	@Autowired private HouseService houseService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	   public String defaultPage(ModelMap model) {
	      model.addAttribute("message", "Hello to Society Management!");
	      return "login";
	   }
	
	@RequestMapping(value = "SocietyBuildingHouses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getSocietyBuildingHouses() {
		Map<String, Object> models = new HashMap<String, Object>();
		models.put("societies", societyService.listAllSociety());
		models.put("buildings", buildingService.listAllBuilding());
		models.put("houses", houseService.listAllHouse());
		return models;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	@ResponseBody
	   public String login(@RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout) {
	      
	      return "login";
	   }
}
