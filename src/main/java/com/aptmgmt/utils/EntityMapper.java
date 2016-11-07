package com.aptmgmt.utils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aptmgmt.dao.accesstoken.AccessTokenDAO;
import com.aptmgmt.dao.building.BuildingDAO;
import com.aptmgmt.dao.house.HouseDAO;
import com.aptmgmt.dao.society.SocietyDAO;
import com.aptmgmt.dao.user.UserDAO;
import com.aptmgmt.dao.userrole.UserRoleDAO;
import com.aptmgmt.entity.Entity;
import com.aptmgmt.model.Building;
import com.aptmgmt.model.House;
import com.aptmgmt.model.Roles;
import com.aptmgmt.model.Society;
import com.aptmgmt.model.User;
import com.aptmgmt.model.UserInfo;
import com.aptmgmt.model.UserRole;

@Service
public class EntityMapper {

	private com.aptmgmt.entity.UserRole userRoleEntity;
	private com.aptmgmt.entity.Roles rolesEntity;
	private com.aptmgmt.entity.User userEntity;
	private com.aptmgmt.entity.Building buildingEntity;
	private com.aptmgmt.entity.House houseEntity;
	private com.aptmgmt.entity.Society societyEntity;
	private com.aptmgmt.entity.UserInfo userinfoEntity;


	private UserDAO userDao;

	private SocietyDAO societyDao;

	private HouseDAO houseDao;

	private BuildingDAO buildingDao;

	private UserRoleDAO userRoleDao;

	private AccessTokenDAO accessTokenDao;

	public com.aptmgmt.entity.User map(User userModel, final String accessToken) {
		if (userModel == null) {
			return null;
		}
		userEntity = new com.aptmgmt.entity.User();
		userEntity.setEnabled(true);
		userEntity.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
		userEntity.setUserInfo(map(userModel.getUserinfo()));
		userEntity.setHousesForResidentid(null);
		userEntity.setHousesForResidentid(null);
		userEntity.setSocieties(null);
		userEntity.setUserRoleesForUserId(null);
		userEntity.setId(userModel.getId());
		userEntity.setUsername(userModel.getUsername());
		userEntity.setUserRoleesForUserId(getDefaultUserRole());
		this.setCommonFields(userEntity, accessToken);
		return userEntity;
	}

	public com.aptmgmt.entity.UserInfo map(UserInfo userInfoModel) {
		if (userInfoModel == null) {
			return null;
		}
		userinfoEntity = new com.aptmgmt.entity.UserInfo();
		userinfoEntity.setFirstname(userInfoModel.getFirstname());
		userinfoEntity.setLastname(userInfoModel.getLastname());
		userinfoEntity.setContact(userInfoModel.getContact());
		userinfoEntity.setEmail(userInfoModel.getEmail());
		//TODO: DOB, Gender, Identity Type, Identitynumber should be mapped from model  
		userinfoEntity.setDob(new Date());
		userinfoEntity.setGender("MALE");
		userinfoEntity.setIdentitytype("SSN");
		userinfoEntity.setIdentitynumber("XXX-XX-XXXX");
		userinfoEntity.setUsers(null);
		return userinfoEntity;
	}

	public com.aptmgmt.entity.UserRole map(UserRole userRoleModel) {
		if (userRoleModel == null) {
			return null;
		}
		userRoleEntity = new com.aptmgmt.entity.UserRole();
		userRoleEntity.setId(userRoleModel.getId());
		userRoleEntity.setRoles(map(userRoleModel.getRoles()));
		return userRoleEntity;
	}

	public com.aptmgmt.entity.Roles map(Roles roleModel) {
		if (roleModel == null) {
			return null;
		}
		rolesEntity = new com.aptmgmt.entity.Roles();
		rolesEntity.setId(roleModel.getId());
		rolesEntity.setRole(roleModel.getRole());
		rolesEntity.setUserRolees(null);
		return rolesEntity;
	}

	public com.aptmgmt.entity.House map(House houseModel) {
		if (houseModel == null) {
			return null;
		}
		houseEntity = new com.aptmgmt.entity.House();
		houseEntity.setAddress(houseModel.getAddress());
		houseEntity.setBuilding(map(houseModel.getBuilding()));
		houseEntity.setContact(houseModel.getContact());
		houseEntity.setHousenum(houseModel.getHousenum());
		houseEntity.setId(houseModel.getId());
		houseEntity.setUserByOwnerid(null);
		houseEntity.setUserByResidentid(null);
		return houseEntity;
	}

	public com.aptmgmt.entity.Building map(Building buildingModel) {
		if (buildingModel == null) {
			return null;
		}
		buildingEntity = new com.aptmgmt.entity.Building();
		buildingEntity.setAddress(buildingModel.getAddress());
		buildingEntity.setBuildingid(buildingModel.getBuildingid());
		buildingEntity.setContact(buildingModel.getContact());
		buildingEntity.setHouses(null);
		buildingEntity.setId(buildingModel.getId());
		buildingEntity.setName(buildingModel.getName());
		buildingEntity.setSecretaryid(buildingModel.getSecretaryid());
		buildingEntity.setSociety(map(buildingModel.getSociety()));
		return buildingEntity;
	}

	public com.aptmgmt.entity.Society map(Society societyModel) {
		if (societyModel == null) {
			return null;
		}
		societyEntity = new com.aptmgmt.entity.Society();
		societyEntity.setAddress(societyModel.getAddress());
		societyEntity.setBuildings(null);
		societyEntity.setContact(societyModel.getContact());
		societyEntity.setId(societyModel.getId());
		societyEntity.setName(societyModel.getName());
		societyEntity.setSocid(societyModel.getSocid());
		societyEntity.setUser(null);
		return societyEntity;
	}

	private Set<com.aptmgmt.entity.House> mapHouseSet(Set<House> housesModel) {
		Set<com.aptmgmt.entity.House> houses = new HashSet<com.aptmgmt.entity.House>();
		for (House house : housesModel) {
			houses.add(map(house));
		}
		return houses;
	}

	private Set<com.aptmgmt.entity.Building> mapBuildingSet(Set<Building> buildingsModel) {
		Set<com.aptmgmt.entity.Building> buildings = new HashSet<com.aptmgmt.entity.Building>();
		for (Building building : buildingsModel) {
			buildings.add(map(building));
		}
		return buildings;
	}

	/*
	 * private Set<com.aptmgmt.entity.User> mapUserSet(Set<User> usersModel ) {
	 * Set<com.aptmgmt.entity.User> users = new
	 * HashSet<com.aptmgmt.entity.User>(); for(User user: usersModel) {
	 * users.add(map(user)); } return users; }
	 */

	private Set<com.aptmgmt.entity.UserRole> mapUserRoleSet(Set<UserRole> userRolesModel) {
		Set<com.aptmgmt.entity.UserRole> userRoles = new HashSet<com.aptmgmt.entity.UserRole>();
		for (UserRole userRole : userRolesModel) {
			userRoles.add(map(userRole));
		}
		return userRoles;
	}

	private Set<com.aptmgmt.entity.Society> mapSocietySet(Set<Society> societiesModel) {
		Set<com.aptmgmt.entity.Society> societies = new HashSet<com.aptmgmt.entity.Society>();
		for (Society society : societiesModel) {
			societies.add(map(society));
		}
		return societies;
	}

	private void setCommonFields(Entity obj, final String accessToken) {
		com.aptmgmt.entity.User currentUser = null;
		Integer uid = null;
		if (accessToken != null) {
			currentUser = getUserByAccessToken(accessToken);
			uid = currentUser.getId();
		}
		if (obj != null) {
			if (obj instanceof com.aptmgmt.entity.User) {
				com.aptmgmt.entity.User user = (com.aptmgmt.entity.User) obj;
				if (user.getId() == null || user.getId() == 0) {
					uid = userDao.findMaxId() + 1;
					user.setId(uid);
					user.setRowstate(1);
					user.setLoggedby(uid);
					user.getUserInfo().setLoggedby(uid);
					user.setLoggeddate(new Date());
					user.getUserInfo().setLoggeddate(new Date());
					user.getUserInfo().setRowstate(1);
					
				} else {
					
					uid = currentUser.getId();
					user.setRowstate(currentUser.getRowstate()+1);
					user.setLastupdatedby(uid);
					user.setLastupdateddate(new Date());
				}
			}
			if (obj instanceof com.aptmgmt.entity.Building) {
				com.aptmgmt.entity.Building currentBuilding = (com.aptmgmt.entity.Building) obj;
				if (currentBuilding.getId() == null || currentBuilding.getId() == 0) {
					currentBuilding.setRowstate(1);
					currentBuilding.setLoggedby(uid);
					currentBuilding.setLoggeddate(new Date());
				} else {
					//TODO: Rowstate in case of update Building, House, Society
					currentBuilding.setRowstate(1);
					currentBuilding.setLastupdatedby(uid);
					currentBuilding.setLastupdateddate(new Date());
				}

			} else if (obj instanceof com.aptmgmt.entity.House) {
				com.aptmgmt.entity.House currentHouse = (com.aptmgmt.entity.House) obj;
				if (currentHouse.getId() == null || currentHouse.getId() == 0) {
					currentHouse.setRowstate(1);
					currentHouse.setLoggedby(uid);
					currentHouse.setLoggeddate(new Date());
				} else {
					currentHouse.setRowstate(1);
					currentHouse.setLastupdatedby(uid);
					currentHouse.setLastupdateddate(new Date());
				}
			} else if (obj instanceof com.aptmgmt.entity.Society) {
				com.aptmgmt.entity.Society currentSociety = (com.aptmgmt.entity.Society) obj;
				if (currentSociety.getId() == null || currentSociety.getId() == 0) {
					currentSociety.setRowstate(1);
					currentSociety.setLoggedby(uid);
					currentSociety.setLoggeddate(new Date());
				} else {
					currentSociety.setRowstate(1);
					currentSociety.setLastupdatedby(uid);
					currentSociety.setLastupdateddate(new Date());
				}
			}
		}
	}

	private Set<com.aptmgmt.entity.UserRole> getDefaultUserRole() {
		Set<com.aptmgmt.entity.UserRole> roles = new HashSet<com.aptmgmt.entity.UserRole>();
		roles.add(userRoleDao.findAll().get(0));
		return roles;
	}

	private com.aptmgmt.entity.User getUserByAccessToken(final String accessToken) {
		return accessTokenDao.findByToken(accessToken).getUser();
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public SocietyDAO getSocietyDao() {
		return societyDao;
	}

	public HouseDAO getHouseDao() {
		return houseDao;
	}

	public BuildingDAO getBuildingDao() {
		return buildingDao;
	}

	public UserRoleDAO getUserRoleDao() {
		return userRoleDao;
	}

	public AccessTokenDAO getAccessTokenDao() {
		return accessTokenDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public void setSocietyDao(SocietyDAO societyDao) {
		this.societyDao = societyDao;
	}

	public void setHouseDao(HouseDAO houseDao) {
		this.houseDao = houseDao;
	}

	public void setBuildingDao(BuildingDAO buildingDao) {
		this.buildingDao = buildingDao;
	}

	public void setUserRoleDao(UserRoleDAO userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public void setAccessTokenDao(AccessTokenDAO accessTokenDao) {
		this.accessTokenDao = accessTokenDao;
	}

}
