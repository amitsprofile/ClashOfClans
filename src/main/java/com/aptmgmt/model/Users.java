package com.aptmgmt.model;
// Generated Oct 24, 2016 11:01:43 PM by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Users implements java.io.Serializable, UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
	private int id;
	private String password;
	private boolean enabled;
	private int rowstate;
	private int loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;
	private Set<UserRoles> userRolesesForUsername = new HashSet<UserRoles>(0);
	private Set<House> housesForResidentid = new HashSet<House>(0);
	private Set<House> housesForOwnerid = new HashSet<House>(0);
	private Set<Society> societies = new HashSet<Society>(0);
	private Set<UserRoles> userRolesesForUserId = new HashSet<UserRoles>(0);

	/* Spring Security related fields */
	@Transient
	private Set<Roles> authorities;
	@Transient
	private boolean accountNonExpired = true;
	@Transient
	private boolean accountNonLocked = true;
	@Transient
	private boolean credentialsNonExpired = true;

	@Transient
	public Set<Roles> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Roles> authorities) {
		this.authorities = authorities;
	}

	@Transient
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Users() {
	}

	public Users(int id, String password, boolean enabled, int rowstate, int loggedby, Date loggeddate) {
		this.id = id;
		this.password = password;
		this.enabled = enabled;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
	}

	public Users(int id, String username, String password, boolean enabled) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Users(String username, int id, String password, boolean enabled, int rowstate, int loggedby, Date loggeddate,
			Integer lastupdatedby, Date lastupdateddate, Set<UserRoles> userRolesesForUsername,
			Set<House> housesForResidentid, Set<House> housesForOwnerid, Set<Society> societies,
			Set<UserRoles> userRolesesForUserId, Set<Roles> authorities, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired) {
		super();
		this.username = username;
		this.id = id;
		this.password = password;
		this.enabled = enabled;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.userRolesesForUsername = userRolesesForUsername;
		this.housesForResidentid = housesForResidentid;
		this.housesForOwnerid = housesForOwnerid;
		this.societies = societies;
		this.userRolesesForUserId = userRolesesForUserId;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Users(int id, String password, boolean enabled, int rowstate, int loggedby, Date loggeddate,
			Integer lastupdatedby, Date lastupdateddate, Set<UserRoles> userRolesesForUsername,
			Set<House> housesForResidentid, Set<House> housesForOwnerid, Set<Society> societies,
			Set<UserRoles> userRolesesForUserId) {
		this.id = id;
		this.password = password;
		this.enabled = enabled;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.userRolesesForUsername = userRolesesForUsername;
		this.housesForResidentid = housesForResidentid;
		this.housesForOwnerid = housesForOwnerid;
		this.societies = societies;
		this.userRolesesForUserId = userRolesesForUserId;
	}

	
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public boolean getEnabled() { return this.enabled; }
	 */

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUsername")
	public Set<UserRoles> getUserRolesesForUsername() {
		return this.userRolesesForUsername;
	}

	public void setUserRolesesForUsername(Set<UserRoles> userRolesesForUsername) {
		this.userRolesesForUsername = userRolesesForUsername;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByResidentid")
	public Set<House> getHousesForResidentid() {
		return this.housesForResidentid;
	}

	public void setHousesForResidentid(Set<House> housesForResidentid) {
		this.housesForResidentid = housesForResidentid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByOwnerid")
	public Set<House> getHousesForOwnerid() {
		return this.housesForOwnerid;
	}

	public void setHousesForOwnerid(Set<House> housesForOwnerid) {
		this.housesForOwnerid = housesForOwnerid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Society> getSocieties() {
		return this.societies;
	}

	public void setSocieties(Set<Society> societies) {
		this.societies = societies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	public Set<UserRoles> getUserRolesesForUserId() {
		return this.userRolesesForUserId;
	}

	public void setUserRolesesForUserId(Set<UserRoles> userRolesesForUserId) {
		this.userRolesesForUserId = userRolesesForUserId;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getUsername()).toHashCode();
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
		Users other = (Users) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).append(this.getUsername(), other.getUsername())
				.isEquals();
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", id=" + id + ", password=" + password + ", enabled=" + enabled
				+ ", rowstate=" + rowstate + ", loggedby=" + loggedby + ", loggeddate=" + loggeddate
				+ ", lastupdatedby=" + lastupdatedby + ", lastupdateddate=" + lastupdateddate
				+ ", userRolesesForUsername=" + userRolesesForUsername + ", housesForResidentid=" + housesForResidentid
				+ ", housesForOwnerid=" + housesForOwnerid + ", societies=" + societies + ", userRolesesForUserId="
				+ userRolesesForUserId + "]";
	}

	@Override
	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

}
