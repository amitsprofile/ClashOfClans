package com.aptmgmt.model;
// Generated Oct 24, 2016 11:01:43 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * UserRoles Model
 * 
 * @author Prakash Manwani
 */
@Entity
@Cacheable
@Cache(region = "user_roles", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "user_roles", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = { "roleid",
		"username" }))
public class UserRoles implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userRoleId;
	private Roles roles;
	private Users usersByUsername;
	private Users usersByUserId;
	private int rowstate;
	private int loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;

	public UserRoles() {
	}

	public UserRoles(Roles roles, Users usersByUsername, Users usersByUserId, int rowstate, int loggedby,
			Date loggeddate) {
		this.roles = roles;
		this.usersByUsername = usersByUsername;
		this.usersByUserId = usersByUserId;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
	}

	public UserRoles(Roles roles, Users usersByUsername, Users usersByUserId, int rowstate, int loggedby,
			Date loggeddate, Integer lastupdatedby, Date lastupdateddate) {
		this.roles = roles;
		this.usersByUsername = usersByUsername;
		this.usersByUserId = usersByUserId;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_role_id", unique = true, nullable = false)
	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleid", nullable = false)
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	public Users getUsersByUsername() {
		return this.usersByUsername;
	}

	public void setUsersByUsername(Users usersByUsername) {
		this.usersByUsername = usersByUsername;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public Users getUsersByUserId() {
		return this.usersByUserId;
	}

	public void setUsersByUserId(Users usersByUserId) {
		this.usersByUserId = usersByUserId;
	}

	@Column(name = "rowstate", nullable = false)
	public int getRowstate() {
		return this.rowstate;
	}

	public void setRowstate(int rowstate) {
		this.rowstate = rowstate;
	}

	@Column(name = "loggedby", nullable = false)
	public int getLoggedby() {
		return this.loggedby;
	}

	public void setLoggedby(int loggedby) {
		this.loggedby = loggedby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "loggeddate", nullable = false, length = 19)
	public Date getLoggeddate() {
		return this.loggeddate;
	}

	public void setLoggeddate(Date loggeddate) {
		this.loggeddate = loggeddate;
	}

	@Column(name = "lastupdatedby")
	public Integer getLastupdatedby() {
		return this.lastupdatedby;
	}

	public void setLastupdatedby(Integer lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastupdateddate", length = 19)
	public Date getLastupdateddate() {
		return this.lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getUserRoleId()).append(this.getUsersByUserId().getId())
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
		UserRoles other = (UserRoles) obj;
		return new EqualsBuilder().append(this.getUserRoleId(), other.getUserRoleId())
				.append(this.getUsersByUserId().getId(), other.getUsersByUserId().getId())
				.append(this.getRoles().getId(), other.getRoles().getId()).isEquals();
	}

	@Override
	public String toString() {
		return "UserRoles [userRoleId=" + userRoleId + ", roles=" + roles + ", usersByUsername=" + usersByUsername
				+ ", usersByUserId=" + usersByUserId + ", rowstate=" + rowstate + ", loggedby=" + loggedby
				+ ", loggeddate=" + loggeddate + ", lastupdatedby=" + lastupdatedby + ", lastupdateddate="
				+ lastupdateddate + "]";
	}

}
