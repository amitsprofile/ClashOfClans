package com.aptmgmt.model;
// Generated Oct 24, 2016 11:01:43 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Roles {


	private Integer id;
	private String role;
	private Set<UserRole> userRolees = new HashSet<UserRole>(0);

	public Roles() {
	}

	public Roles(String role) {
		this.role = role;
	}

	public Roles(String role, Set<UserRole> userRolees) {
		this.role = role;
		this.userRolees = userRolees;
	}

	public Integer getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public Set<UserRole> getUserRolees() {
		return userRolees;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getRole()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Roles other = (Roles) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).append(this.getRole(), other.getRole())
				.isEquals();
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", role=" + role + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUserRolees(Set<UserRole> userRolees) {
		this.userRolees = userRolees;
	}
}
