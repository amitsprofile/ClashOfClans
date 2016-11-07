package com.aptmgmt.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aptmgmt.entity.House;
import com.aptmgmt.services.HouseService;

@Controller
@RequestMapping("/house")
public class HouseController {

	private HouseService houseService;

	/**
	 * Testing via Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring-core-config.xml");
		HouseService houseService = ctx.getBean(HouseService.class);
		List<House> houses = houseService.listAllHouse();
		for (House house : houses) {
			System.out.println("House Name: " + house.getHousenum());
		}
		ctx.close();
	}

	@RequestMapping(value = "addhouse", method = RequestMethod.POST)
	public @ResponseBody House addHouse(@RequestParam(value = "house") House house) {
		return houseService.addHouse(house);
	}

	@RequestMapping(value = "getallhouses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<House> getAllHouses() {
		return houseService.listAllHouse();
	}

	public HouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(HouseService houseService) {
		this.houseService = houseService;
	}
}
