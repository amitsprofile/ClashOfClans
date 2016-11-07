package com.aptmgmt.model;

import java.util.HashSet;
import java.util.Set;

import com.aptmgmt.model.House;
import com.aptmgmt.model.Society;
import com.aptmgmt.model.UserRole;

public class User {

	private String username;
	private Integer id;
	private String password;
	private UserInfo userinfo;
	private boolean enabled;
	private Set<House> housesForResidentid = new HashSet<House>(0);
	private Set<House> housesForOwnerid = new HashSet<House>(0);
	private Set<Society> societies = new HashSet<Society>(0);
	private Set<UserRole> userRoleesForUserId = new HashSet<UserRole>(0);


	public User() {
	}


	public String getUsername() {
		return username;
	}


	public Integer getId() {
		return id;
	}


	public String getPassword() {
		return password;
	}


	public UserInfo getUserinfo() {
		return userinfo;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Set<House> getHousesForResidentid() {
		return housesForResidentid;
	}


	public Set<House> getHousesForOwnerid() {
		return housesForOwnerid;
	}


	public Set<Society> getSocieties() {
		return societies;
	}


	public Set<UserRole> getUserRoleesForUserId() {
		return userRoleesForUserId;
	}


	public void setHousesForResidentid(Set<House> housesForResidentid) {
		this.housesForResidentid = housesForResidentid;
	}


	public void setHousesForOwnerid(Set<House> housesForOwnerid) {
		this.housesForOwnerid = housesForOwnerid;
	}


	public void setSocieties(Set<Society> societies) {
		this.societies = societies;
	}


	public void setUserRoleesForUserId(Set<UserRole> userRoleesForUserId) {
		this.userRoleesForUserId = userRoleesForUserId;
	}
	
}
