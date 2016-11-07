package com.aptmgmt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aptmgmt.entity.House;
import com.aptmgmt.entity.User;
import com.aptmgmt.services.BuildingService;
import com.aptmgmt.services.HouseService;
import com.aptmgmt.services.SocietyService;
import com.aptmgmt.services.UserDetailService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private SocietyService societyService;

	private BuildingService buildingService;

	private HouseService houseService;

	private UserDetailService userService;

	@RequestMapping(value = "default", method = RequestMethod.GET)
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

	@RequestMapping(value = "admin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = null;
		if (principal instanceof User) {
			user = ((User) principal);
		}
		return user;
	}

	@RequestMapping(value = "getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public House getUser() {
		Integer id = ((User) userService.loadUserByUsername("manwaniprakash87@gmail.com")).getId();
		return houseService.findHouseByUserId(id);
	}

	@RequestMapping(value = "nomap", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User signUp(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "house") House newHouseUser) {
		return null;
	}

	public SocietyService getSocietyService() {
		return societyService;
	}

	public BuildingService getBuildingService() {
		return buildingService;
	}

	public HouseService getHouseService() {
		return houseService;
	}

	public UserDetailService getUserService() {
		return userService;
	}

	public void setSocietyService(SocietyService societyService) {
		this.societyService = societyService;
	}

	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}

	public void setUserService(UserDetailService userService) {
		this.userService = userService;
	}

}
