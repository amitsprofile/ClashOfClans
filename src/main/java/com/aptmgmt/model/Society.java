package com.aptmgmt.model;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Society{

	private Integer id;
	private User user;
	private String socid;
	private String name;
	private String address;
	private String contact;
	private Set<Building> buildings = new HashSet<Building>(0);

	public Society() {
	}

	public Society(User user, String socid, String name) {
		this.user = user;
		this.socid = socid;
		this.name = name;
	}

	public Society(User user, String socid, String name, String address, String contact, Set<Building> buildings) {
		this.user = user;
		this.socid = socid;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.buildings = buildings;
	}

	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getSocid() {
		return socid;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getContact() {
		return contact;
	}

	public Set<Building> getBuildings() {
		return buildings;
	}

	@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Society other = (Society) object;

        return new EqualsBuilder().append(this.getId(), other.getId())
                .append(this.getName(), other.getName()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).append(getName()).toHashCode();
    }

	@Override
	public String toString() {
		return "Society [id=" + id + ", socid=" + socid + ", name=" + name + ", address=" + address
				+ ", contact=" + contact + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSocid(String socid) {
		this.socid = socid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}

}
