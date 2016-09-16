package com.aptmgmt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aptmgmt.dao.SocietyDAO;
import com.aptmgmt.model.Society;

@Service
public class SocietyServiceImpl implements SocietyService {

	@Autowired
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
	
}
