package com.aptmgmt.model;
// Generated Sep 14, 2016 3:22:12 AM by Hibernate Tools 4.3.1.Final

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class House{

	private Integer id;
	private Building building;
	private User userByResidentid;
	private User userByOwnerid;
	private String housenum;
	private String address;
	private String contact;

	public House() {
	}

	public House(Building building, User userByResidentid, User userByOwnerid, String housenum) {
		this.building = building;
		this.userByResidentid = userByResidentid;
		this.userByOwnerid = userByOwnerid;
		this.housenum = housenum;
	}

	public House(Building building, User userByResidentid, User userByOwnerid, String housenum, String address,
			String contact) {
		this.building = building;
		this.userByResidentid = userByResidentid;
		this.userByOwnerid = userByOwnerid;
		this.housenum = housenum;
		this.address = address;
		this.contact = contact;
	}

	public Integer getId() {
		return id;
	}

	public Building getBuilding() {
		return building;
	}

	public User getUserByResidentid() {
		return userByResidentid;
	}

	public User getUserByOwnerid() {
		return userByOwnerid;
	}

	public String getHousenum() {
		return housenum;
	}

	public String getAddress() {
		return address;
	}

	public String getContact() {
		return contact;
	}

	@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        House other = (House) object;

        return new EqualsBuilder().append(this.getId(), other.getId())
                .append(this.getHousenum(), other.getHousenum()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).append(getHousenum()).toHashCode();
    }
    
	@Override
	public String toString() {
		return "House [id=" + id + ", building=" + building.getName() + ", userByResidentid=" + userByResidentid.getId()
				+ ", userByOwnerid=" + userByOwnerid.getId() + ", housenum=" + housenum + ", address=" + address
				+ ", contact=" + contact + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public void setUserByResidentid(User userByResidentid) {
		this.userByResidentid = userByResidentid;
	}

	public void setUserByOwnerid(User userByOwnerid) {
		this.userByOwnerid = userByOwnerid;
	}

	public void setHousenum(String housenum) {
		this.housenum = housenum;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
