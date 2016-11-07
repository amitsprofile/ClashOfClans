package com.aptmgmt.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptmgmt.dao.society.SocietyDAO;
import com.aptmgmt.entity.Society;

@Service
public class SocietyServiceImpl implements SocietyService {

	private SocietyDAO societyDao;
	
	@Transactional
	public Society addSociety(Society society){
		societyDao.persist(society);
		return societyDao.findByUniqueKey(society.getName());
	}
	
	@Transactional
	public void addAllSociety(List<Society> societies){
		for (Society society : societies){
			societyDao.persist(society);
		}
	}
	
	@Transactional
	public List<Society> listAllSociety(){
		return societyDao.findAll();
	}
	
	@Transactional
	public Society findBySocietyName(String societyName){
		return societyDao.findByUniqueKey(societyName);
	}
	
	@Transactional
	public Integer getMaxId(){
		return societyDao.findMaxId();
	}

	public void setSocietyDao(SocietyDAO societyDao) {
		this.societyDao = societyDao;
	}

	public SocietyDAO getSocietyDao() {
		return societyDao;
	}
	
}
