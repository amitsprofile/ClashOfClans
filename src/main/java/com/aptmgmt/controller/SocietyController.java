package com.aptmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aptmgmt.model.Building;
import com.aptmgmt.model.Society;
import com.aptmgmt.services.SocietyService;

@Controller
@RequestMapping("/society/")
public class SocietyController {

	@Autowired
	private SocietyService societyService;
	
	@RequestMapping(value = "addsociety")
	public @ResponseBody Society addSociety(Society society) {
		return societyService.addSociety(society);
	}
	
	@RequestMapping(value = "getallsocieties", method = RequestMethod.GET)
	public @ResponseBody List<Society> getAllHouses() {
		return societyService.listAllSociety();
	}
}
