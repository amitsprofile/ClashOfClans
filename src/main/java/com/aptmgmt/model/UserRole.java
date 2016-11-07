package com.aptmgmt.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UserRole {

	private Integer id;
	private Roles roles;
	private User userByUserId;

	public UserRole() {
	}

	public UserRole(Roles roles, User userByUserId) {
		this.roles = roles;
		this.userByUserId = userByUserId;
	}

	public Integer getId() {
		return id;
	}

	public Roles getRoles() {
		return roles;
	}

	public User getUserByUserId() {
		return userByUserId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId())
				.append(this.getRoles().getId()).toHashCode();
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
		UserRole other = (UserRole) obj;
		return new EqualsBuilder().append(this.getId(), other.getId())
				.append(this.getRoles().getId(), other.getRoles().getId()).isEquals();
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + id + ", roles=" + roles + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}
}
