package com.aptmgmt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * AccessToken Entity
 * 
 * @author Prakash Manwani
 */
@javax.persistence.Entity
public class AccessToken implements Entity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String token;

	@ManyToOne
	@JsonBackReference
	private User user;

	@Column
	private Date expiry;
	
	private Integer rowstate;
	private Integer loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;


	protected AccessToken() {
		/* Reflection instantiation */
	}

	public AccessToken(User user, String token) {
		this.user = user;
		this.token = token;
	}

	public AccessToken(User user, String token, Date expiry) {
		this(user, token);
		this.expiry = expiry;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	public String getToken() {
		return this.token;
	}

	public User getUser() {
		return this.user;
	}

	public Date getExpiry() {
		return this.expiry;
	}
	
	public Integer getRowstate() {
		return this.rowstate;
	}

	public Integer getLoggedby() {
		return this.loggedby;
	}

	public Date getLoggeddate() {
		return this.loggeddate;
	}

	public Integer getLastupdatedby() {
		return this.lastupdatedby;
	}

	public Date getLastupdateddate() {
		return this.lastupdateddate;
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

	public boolean isExpired() {
		if (null == this.expiry) {
			return false;
		}

		return this.expiry.getTime() > System.currentTimeMillis();
	}
}
