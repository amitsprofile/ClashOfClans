package com.aptmgmt.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * User Entity
 * 
 * @author Prakash Manwani
 */
@javax.persistence.Entity
@Table(name = "user", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class User implements Entity, UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
	private Integer id;
	private String password;
	private UserInfo userInfo;
	private boolean enabled;
	private Integer rowstate;
	private Integer loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;
	private Set<House> housesForResidentid = new HashSet<House>(0);
	private Set<House> housesForOwnerid = new HashSet<House>(0);
	private Set<Society> societies = new HashSet<Society>(0);
	private Set<UserRole> userRoleesForUserId = new HashSet<UserRole>(0);

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

	@Transient
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Transient
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public User() {
	}

	public User(Integer id, String password, boolean enabled, Integer rowstate, Integer loggedby, Date loggeddate, UserInfo userInfo) {
		this.id = id;
		this.password = password;
		this.enabled = enabled;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.userInfo = userInfo;
	}

	public User(Integer id, String username, String password, boolean enabled, UserInfo userInfo) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userInfo = userInfo;
	}

	public User(String username, Integer id, String password, UserInfo userInfo, boolean enabled, Integer rowstate, Integer loggedby, Date loggeddate,
			Integer lastupdatedby, Date lastupdateddate, 
			Set<House> housesForResidentid, Set<House> housesForOwnerid, Set<Society> societies,
			Set<UserRole> userRoleesForUserId, Set<Roles> authorities, boolean accountNonExpired,
			boolean accountNonLocked, boolean credentialsNonExpired) {
		super();
		this.username = username;
		this.id = id;
		this.password = password;
		this.enabled = enabled;
		this.userInfo = userInfo;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.housesForResidentid = housesForResidentid;
		this.housesForOwnerid = housesForOwnerid;
		this.societies = societies;
		this.userRoleesForUserId = userRoleesForUserId;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public User(Integer id, String password, boolean enabled, UserInfo userInfo, Integer rowstate, Integer loggedby, Date loggeddate,
			Integer lastupdatedby, Date lastupdateddate, 
			Set<House> housesForResidentid, Set<House> housesForOwnerid, Set<Society> societies,
			Set<UserRole> userRoleesForUserId) {
		this.id = id;
		this.password = password;
		this.enabled = enabled;
		this.userInfo = userInfo;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.housesForResidentid = housesForResidentid;
		this.housesForOwnerid = housesForOwnerid;
		this.societies = societies;
		this.userRoleesForUserId = userRoleesForUserId;
	}

	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userinfoid", nullable = false)
	@JsonBackReference
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Column(name = "password", nullable = false, length = 512)
	public String getPassword() {
		return this.password;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userByResidentid")
	@JsonManagedReference
	public Set<House> getHousesForResidentid() {
		return this.housesForResidentid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userByOwnerid")
	@JsonManagedReference
	public Set<House> getHousesForOwnerid() {
		return this.housesForOwnerid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@JsonManagedReference
	public Set<Society> getSocieties() {
		return this.societies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userByUserId")
	@JsonManagedReference
	public Set<UserRole> getUserRoleesForUserId() {
		return this.userRoleesForUserId;
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
		User other = (User) obj;
		return new EqualsBuilder().append(this.getId(), other.getId()).append(this.getUsername(), other.getUsername())
				.isEquals();
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", id=" + id + ", password=" + password + ", enabled=" + enabled
				+ ", rowstate=" + rowstate + ", loggedby=" + loggedby + ", loggeddate=" + loggeddate
				+ ", lastupdatedby=" + lastupdatedby + ", lastupdateddate=" + lastupdateddate + "]";
	}

	@Override
	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public void setHousesForResidentid(Set<House> housesForResidentid) {
		this.housesForResidentid = housesForResidentid;
	}

	public void setHousesForOwnerid(Set<House> housesForOwnerid) {
		this.housesForOwnerid = housesForOwnerid;
	}

	public void setSocieties(Set<Society> societies) {
		this.societies = societies;
	}

	public void setUserRoleesForUserId(Set<UserRole> userRoleesForUserId) {
		this.userRoleesForUserId = userRoleesForUserId;
	}

	public void setAuthorities(Set<Roles> authorities) {
		this.authorities = authorities;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
}
