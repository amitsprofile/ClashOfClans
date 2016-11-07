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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Roles Entity
 * 
 * @author Prakash Manwani
 */
@javax.persistence.Entity
@Table(name = "roles", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = "role"))
public class Roles implements Entity, GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String role;
	private Integer rowstate;
	private Integer loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;
	private Set<UserRole> userRolees = new HashSet<UserRole>(0);

	public Roles() {
	}

	public Roles(String role, Integer rowstate, Integer loggedby, Date loggeddate) {
		this.role = role;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
	}

	public Roles(String role, Integer rowstate, Integer loggedby, Date loggeddate, Integer lastupdatedby, Date lastupdateddate,
			Set<UserRole> userRolees) {
		this.role = role;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.userRolees = userRolees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	@Column(name = "role", unique = true, nullable = false, length = 45)
	public String getRole() {
		return this.role;
	}

	@Column(name = "rowstate", nullable = false)
	public Integer getRowstate() {
		return this.rowstate;
	}

	@Column(name = "loggedby", nullable = false)
	public Integer getLoggedby() {
		return this.loggedby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "loggeddate", nullable = false, length = 19)
	public Date getLoggeddate() {
		return this.loggeddate;
	}

	@Column(name = "lastupdatedby")
	public Integer getLastupdatedby() {
		return this.lastupdatedby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastupdateddate", length = 19)
	public Date getLastupdateddate() {
		return this.lastupdateddate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	@JsonManagedReference
	public Set<UserRole> getUserRolees() {
		return this.userRolees;
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
		return "Roles [id=" + id + ", role=" + role + ", rowstate=" + rowstate + ", loggedby=" + loggedby
				+ ", loggeddate=" + loggeddate + ", lastupdatedby=" + lastupdatedby + ", lastupdateddate="
				+ lastupdateddate + "]";
	}

	@Override
	@Transient
	public String getAuthority() {
		return this.role;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
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

	public void setUserRolees(Set<UserRole> userRolees) {
		this.userRolees = userRolees;
	}
}
