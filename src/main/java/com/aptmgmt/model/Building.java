package com.aptmgmt.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Building {

	
	private Integer id;
	private Society society;
	private String buildingid;
	private String name;
	private String address;
	private int secretaryid;
	private String contact;
	private Set<House> houses = new HashSet<House>(0);

	public Building() {
	}

	public Building(Society society, String buildingid, String name, int secretaryid) {
		this.society = society;
		this.buildingid = buildingid;
		this.name = name;
		this.secretaryid = secretaryid;
	}

	public Building(Society society, String buildingid, String name, String address, int secretaryid, String contact,
			Set<House> houses) {
		this.society = society;
		this.buildingid = buildingid;
		this.name = name;
		this.address = address;
		this.secretaryid = secretaryid;
		this.contact = contact;
	this.houses = houses;
	}
	

	public Integer getId() {
		return id;
	}

	public Society getSociety() {
		return society;
	}

	public String getBuildingid() {
		return buildingid;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getSecretaryid() {
		return secretaryid;
	}

	public String getContact() {
		return contact;
	}

	public Set<House> getHouses() {
		return houses;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Building other = (Building) object;

		return new EqualsBuilder().append(this.getId(), other.getId()).append(this.getName(), other.getName())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getName()).toHashCode();
	}

	
	@Override
	public String toString() {
		return "Building [id=" + id + ", buildingid=" + buildingid + ", name=" + name
				+ ", address=" + address + ", secretaryid=" + secretaryid + ", contact=" + contact + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSociety(Society society) {
		this.society = society;
	}

	public void setBuildingid(String buildingid) {
		this.buildingid = buildingid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSecretaryid(int secretaryid) {
		this.secretaryid = secretaryid;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

}
