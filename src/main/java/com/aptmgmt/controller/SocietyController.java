package com.aptmgmt.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aptmgmt.entity.Society;
import com.aptmgmt.services.SocietyService;

@Controller
@RequestMapping("/society")
public class SocietyController {

	private SocietyService societyService;

	@RequestMapping(value = "addsociety", method = RequestMethod.POST)
	public @ResponseBody Society addSociety(@RequestParam(value = "society") Society society) {
		return societyService.addSociety(society);
	}

	@RequestMapping(value = "getallsocieties", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Society> getAllHouses() {
		return societyService.listAllSociety();
	}

	public SocietyService getSocietyService() {
		return societyService;
	}

	public void setSocietyService(SocietyService societyService) {
		this.societyService = societyService;
	}
}
