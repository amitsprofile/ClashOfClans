package com.aptmgmt.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.aptmgmt.entity.Building;
import com.aptmgmt.entity.House;
import com.aptmgmt.entity.Roles;
import com.aptmgmt.entity.Society;
import com.aptmgmt.entity.User;
import com.aptmgmt.entity.UserInfo;
import com.aptmgmt.entity.UserRole;

@Component
public class ModelMapper {
	
	 private com.aptmgmt.model.UserRole userRole;
	 private com.aptmgmt.model.Roles roles;
	 private com.aptmgmt.model.User user;
	 private com.aptmgmt.model.Building building;
	 private com.aptmgmt.model.House house;
	 private com.aptmgmt.model.Society society;
	 private com.aptmgmt.model.UserInfo userinfo;
	
	public com.aptmgmt.model.User map(User userEntity) {
		if(userEntity == null){
			return null;
		}
		user = new com.aptmgmt.model.User();
		user.setEnabled(userEntity.isEnabled());
		user.setPassword("{Encrypted}");
		user.setUserinfo(map(userEntity.getUserInfo()));
		user.setHousesForOwnerid(mapHouseSet(userEntity.getHousesForOwnerid()));
		user.setHousesForResidentid(mapHouseSet(userEntity.getHousesForResidentid()));
		user.setId(userEntity.getId());
		user.setSocieties(null);
		user.setUsername(userEntity.getUsername());
		user.setUserRoleesForUserId(mapUserRoleSet(userEntity.getUserRoleesForUserId()));		
		return user;
	}
	
	public com.aptmgmt.model.UserInfo map(UserInfo userInfoEntity){
		if(userInfoEntity == null){
			return null;
		}
		userinfo = new com.aptmgmt.model.UserInfo();
		userinfo.setFirstname(userInfoEntity.getFirstname());
		userinfo.setLastname(userInfoEntity.getLastname());
		userinfo.setContact(userInfoEntity.getContact());
		userinfo.setEmail(userInfoEntity.getEmail());
		//userinfo.setDob(userInfoEntity.getDob());
		userinfo.setGender(userInfoEntity.getGender());
		userinfo.setIdentitytype(userInfoEntity.getIdentitytype());
		userinfo.setIdentitynumber(userInfoEntity.getIdentitynumber());
		//userinfo.setUsers(null);
		return userinfo;
	}
	
	public com.aptmgmt.model.UserRole map(UserRole userRoleEntity) {
			if(userRoleEntity == null){
				return null;
			}
		userRole = new com.aptmgmt.model.UserRole();
		userRole.setId(userRoleEntity.getId());
		userRole.setRoles(map(userRoleEntity.getRoles()));
		return userRole;
	}
	
	public com.aptmgmt.model.Roles map(Roles roleEntity) {
		if(roleEntity == null){
			return null;
		}
		roles = new com.aptmgmt.model.Roles();
		roles.setId(roleEntity.getId());
		roles.setRole(roleEntity.getRole());
		roles.setUserRolees(null);
		return roles;
	}
	
	public com.aptmgmt.model.House map(House houseEntity) {
		if(houseEntity == null){
			return null;
		}
		house = new com.aptmgmt.model.House();
		house.setAddress(houseEntity.getAddress());
		house.setBuilding(map(houseEntity.getBuilding()));
		house.setContact(houseEntity.getContact());
		house.setHousenum(houseEntity.getHousenum());
		house.setId(houseEntity.getId());
		house.setUserByOwnerid(null);
		house.setUserByResidentid(null);
		return house;
	}
	
	public com.aptmgmt.model.Building map(Building buildingEntity) {
		if(buildingEntity == null){
			return null;
		}
		building = new com.aptmgmt.model.Building();
		building.setAddress(buildingEntity.getAddress());
		building.setBuildingid(buildingEntity.getBuildingid());
		building.setContact(buildingEntity.getContact());
		building.setHouses(null);
		building.setId(buildingEntity.getId());
		building.setName(buildingEntity.getName());
		building.setSecretaryid(buildingEntity.getSecretaryid());
		building.setSociety(map(buildingEntity.getSociety()));
		return building;
	}
	
	public com.aptmgmt.model.Society map(Society societyEntity) {
		if (societyEntity == null) {
			return null;
		}
		society = new com.aptmgmt.model.Society();
		society.setAddress(societyEntity.getAddress());
		society.setBuildings(null);
		society.setContact(societyEntity.getContact());
		society.setId(societyEntity.getId());
		society.setName(societyEntity.getName());
		society.setSocid(societyEntity.getSocid());
		society.setUser(null);
		return society;
	}
	
	private Set<com.aptmgmt.model.House> mapHouseSet(Set<House> housesEntity ) {
		Set<com.aptmgmt.model.House> houses = new HashSet<com.aptmgmt.model.House>();
		for(House house: housesEntity) {
			houses.add(map(house));
		}
		return houses;
	}
	
	private Set<com.aptmgmt.model.Building> mapBuildingSet(Set<Building> buildingsEntity ) {
		Set<com.aptmgmt.model.Building> buildings = new HashSet<com.aptmgmt.model.Building>();
		for(Building building: buildingsEntity) {
			buildings.add(map(building));
		}
		return buildings;
	}
	
	private Set<com.aptmgmt.model.User> mapUserSet(Set<User> usersEntity ) {
		Set<com.aptmgmt.model.User> users = new HashSet<com.aptmgmt.model.User>();
		for(User user: usersEntity) {
			users.add(map(user));
		}
		return users;
	}
	
	private Set<com.aptmgmt.model.UserRole> mapUserRoleSet(Set<UserRole> userRolesEntity ) {
		Set<com.aptmgmt.model.UserRole> userRoles = new HashSet<com.aptmgmt.model.UserRole>();
		for(UserRole userRole: userRolesEntity) {
			userRoles.add(map(userRole));
		}
		return userRoles;
	}
	
	private Set<com.aptmgmt.model.Society> mapSocietySet(Set<Society> societiesEntity ) {
		Set<com.aptmgmt.model.Society> societies = new HashSet<com.aptmgmt.model.Society>();
		for(Society society: societiesEntity) {
			societies.add(map(society));
		}
		return societies;
	}
	
}
