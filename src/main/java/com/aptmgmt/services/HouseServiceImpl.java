package com.aptmgmt.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptmgmt.dao.house.HouseDAO;
import com.aptmgmt.entity.House;

@Service
public class HouseServiceImpl implements HouseService {

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
	
	@Transactional
	public Integer getMaxId(){
		return houseDao.findMaxId();
	}

	public void setHouseDao(HouseDAO houseDao) {
		this.houseDao = houseDao;
	}

	public HouseDAO getHouseDao() {
		return houseDao;
	}
	
}
