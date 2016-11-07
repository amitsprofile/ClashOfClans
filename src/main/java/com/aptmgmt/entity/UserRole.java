package com.aptmgmt.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * UserRole Entity
 * 
 * @author Prakash Manwani
 */
@javax.persistence.Entity
@Cacheable
@Cache(region = "user_role", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "user_role", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = { "roleid"}))
public class UserRole implements Entity {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Roles roles;
	private User userByUserId;
	private Integer rowstate;
	private Integer loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;

	public UserRole() {
	}

	public UserRole(Roles roles, User userByUserId, Integer rowstate, Integer loggedby, Date loggeddate) {
		this.roles = roles;
		this.userByUserId = userByUserId;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
	}

	public UserRole(Roles roles, User userByUserId, Integer rowstate, Integer loggedby, Date loggeddate,
			Integer lastupdatedby, Date lastupdateddate) {
		this.roles = roles;
		this.userByUserId = userByUserId;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "user_role_id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid", nullable = false)
	@JsonBackReference
	public Roles getRoles() {
		return this.roles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
	public User getUserByUserId() {
		return this.userByUserId;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getId()).append(this.getUserByUserId().getId())
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
				.append(this.getUserByUserId().getId(), other.getUserByUserId().getId())
				.append(this.getRoles().getId(), other.getRoles().getId()).isEquals();
	}

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + id + ", roles=" + roles + ", rowstate=" + rowstate + ", loggedby=" + loggedby
				+ ", loggeddate=" + loggeddate + ", lastupdatedby=" + lastupdatedby + ", lastupdateddate="
				+ lastupdateddate + "]";
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
