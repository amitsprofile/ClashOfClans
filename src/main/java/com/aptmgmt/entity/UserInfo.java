package com.aptmgmt.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * UserInfo Entity
 * 
 * @author Prakash Manwani
 */
@javax.persistence.Entity
@Table(name = "user_info", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class UserInfo implements Entity {
	
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String firstname;
	private String lastname;
	private String contact;
	private String email;
	private String identitytype;
	private String identitynumber;
	private String gender;
	private Date dob;
	private Integer rowstate;
	private Integer loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;
	private Set<User> users = new HashSet<User>(0);

	public UserInfo(){}
	public UserInfo(Integer id, String firstname, String lastname, String contact, String email, String identitytype,
			String identitynumber, String gender, Date dob, Integer rowstate, Integer loggedby, Date loggeddate,
			Integer lastupdatedby, Date lastupdateddate, Set<User> users) {
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
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.users = users;
	}

	public UserInfo(Integer id, String firstname, String lastname, Integer rowstate, Integer loggedby, Date loggeddate,
			Integer lastupdatedby, Date lastupdateddate, Set<User> users) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.users = users;
	}

	public UserInfo(Integer id, String firstname, String lastname, String contact, String email, String gender, Date dob,
			Integer rowstate, Integer loggedby, Date loggeddate, Integer lastupdatedby, Date lastupdateddate, Set<User> users) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	@Column(name = "firstname", nullable = false, length = 128)
	public String getFirstname() {
		return firstname;
	}

	@Column(name = "lastname", nullable = false, length = 128)
	public String getLastname() {
		return lastname;
	}

	@Column(name = "contact", nullable = false, length = 16)
	public String getContact() {
		return contact;
	}

	@Column(name = "email", nullable = false, length = 64)
	public String getEmail() {
		return email;
	}

	@Column(name = "identitytype", nullable = false, length = 32)
	public String getIdentitytype() {
		return identitytype;
	}

	@Column(name = "identitynumber", nullable = false, length = 64)
	public String getIdentitynumber() {
		return identitynumber;
	}

	@Column(name = "gender", nullable = false, length = 8)
	public String getGender() {
		return gender;
	}

	@Column(name = "dob", nullable = false, length = 19)
	public Date getDob() {
		return dob;
	}

	@Column(name = "rowstate", nullable = false)
	public Integer getRowstate() {
		return rowstate;
	}

	@Column(name = "loggedby", nullable = false)
	public Integer getLoggedby() {
		return loggedby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "loggeddate", nullable = false, length = 19)
	public Date getLoggeddate() {
		return loggeddate;
	}

	@Column(name = "lastupdatedby")
	public Integer getLastupdatedby() {
		return lastupdatedby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastupdateddate", length = 19)
	public Date getLastupdateddate() {
		return lastupdateddate;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userInfo")
	@JsonManagedReference
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
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

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setRowstate(Integer rowstate) {
		this.rowstate = rowstate;
	}

	public void setLoggedby(Integer loggedby) {
		this.loggedby = loggedby;
	}

	public void setLoggeddate(Date loggeddate) {
		this.loggeddate = loggeddate;
	}

	public void setLastupdatedby(Integer lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

}
