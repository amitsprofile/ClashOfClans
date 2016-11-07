package com.aptmgmt.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptmgmt.entity.Building;
import com.aptmgmt.entity.House;
import com.aptmgmt.entity.Society;
import com.aptmgmt.services.BuildingService;
import com.aptmgmt.services.HouseService;
import com.aptmgmt.services.SocietyService;

@Service
public class GenericIDGenerator {

	@Autowired
	private HouseService houseService;
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private SocietyService societyService;

	private String genericID = null;

	public String IDGenerator(Object obj) {
		if (obj != null) {
			if (obj instanceof House) {
				genericID = "HOS-" + (getTrimmed(houseService.getMaxId() + 1));
			} else if (obj instanceof Building) {
				genericID = "BLD-" + (getTrimmed(buildingService.getMaxId() + 1));
			} else if (obj instanceof Society) {
				genericID = "SOC-" + (getTrimmed(societyService.getMaxId() + 1));
			}
		}
		return genericID;
	}

	public String getTrimmed(Integer name) {
		return String.format("%04", name);
	}
}
