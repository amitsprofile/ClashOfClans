package com.aptmgmt.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UserInfo {
	

	private Integer id;
	private String firstname;
	private String lastname;
	private String contact;
	private String email;
	private String identitytype;
	private String identitynumber;
	private String gender;
	private String dob;
	
	public UserInfo() {
	}
	
	public UserInfo(Integer id, String firstname, String lastname, String contact, String email, String identitytype,
			String identitynumber, String gender, String dob) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contact = contact;
		this.email = email;
		this.identitytype = identitytype;
		this.identitynumber = identitynumber;
		this.gender = gender;
		this.dob = dob;
	}

	public UserInfo(Integer id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public UserInfo(Integer id, String firstname, String lastname, String contact, String email, String gender, String dob) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
	}

	public Integer getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getContact() {
		return contact;
	}
	
	public String getEmail() {
		return email;
	}

	public String getIdentitytype() {
		return identitytype;
	}

	public String getIdentitynumber() {
		return identitynumber;
	}

	public String getGender() {
		return gender;
	}

	public String getDob() {
		return dob;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
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
		UserInfo other = (UserInfo) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).isEquals();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdentitytype(String identitytype) {
		this.identitytype = identitytype;
	}

	public void setIdentitynumber(String identitynumber) {
		this.identitynumber = identitynumber;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

}
