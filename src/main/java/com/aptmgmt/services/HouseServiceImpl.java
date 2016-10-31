package com.aptmgmt.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptmgmt.dao.HouseDAO;
import com.aptmgmt.model.House;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDAO houseDao;
	
	@Transactional
	public House addHouse(House house){
		houseDao.persist(house);
		return houseDao.findByUniqueKey(house.getBuilding().getSociety(), house.getBuilding(), house.getHousenum());
	}
	
	@Transactional
	public void addAllHouse(List<House> houses){
		for (House house : houses){
			houseDao.persist(house);
		}
	}
	
	@Transactional
	public List<House> listAllHouse(){
		return houseDao.findAll();
	}
	
	@Transactional
	public House findByHouseNumber(String houseNumber){
		return houseDao.find(houseNumber);
	}
	
	@Transactional
	public House findHouseByUserId(Integer userId){
		return houseDao.findByUserId(userId);
	}
	
}
