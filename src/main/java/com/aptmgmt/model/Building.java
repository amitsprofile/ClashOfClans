package com.aptmgmt.model;
// Generated Sep 14, 2016 3:22:12 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Building Model
 * @author Prakash Manwani
 */
@Entity
@Table(name = "building", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = "buildingid"))
public class Building implements java.io.Serializable {

	private Integer id;
	private Society society;
	private String buildingid;
	private String name;
	private String address;
	private int secretaryid;
	private String contact;
	private int rowstate;
	private int loggedby;
	private Date loggeddate;
	private int lastupdatedby;
	private Date lastupdateddate;
	private Set houses = new HashSet(0);

	public Building() {
	}

	public Building(Society society, String buildingid, String name, int secretaryid, int rowstate, int loggedby,
			Date loggeddate, int lastupdatedby, Date lastupdateddate) {
		this.society = society;
		this.buildingid = buildingid;
		this.name = name;
		this.secretaryid = secretaryid;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
	}

	public Building(Society society, String buildingid, String name, String address, int secretaryid, String contact,
			int rowstate, int loggedby, Date loggeddate, int lastupdatedby, Date lastupdateddate, Set houses) {
		this.society = society;
		this.buildingid = buildingid;
		this.name = name;
		this.address = address;
		this.secretaryid = secretaryid;
		this.contact = contact;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.houses = houses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socid", nullable = false)
	public Society getSociety() {
		return this.society;
	}

	public void setSociety(Society society) {
		this.society = society;
	}

	@Column(name = "buildingid", unique = true, nullable = false, length = 10)
	public String getBuildingid() {
		return this.buildingid;
	}

	public void setBuildingid(String buildingid) {
		this.buildingid = buildingid;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "address", length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "secretaryid", nullable = false)
	public int getSecretaryid() {
		return this.secretaryid;
	}

	public void setSecretaryid(int secretaryid) {
		this.secretaryid = secretaryid;
	}

	@Column(name = "contact", length = 45)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	@Column(name = "lastupdatedby", nullable = false)
	public int getLastupdatedby() {
		return this.lastupdatedby;
	}

	public void setLastupdatedby(int lastupdatedby) {
		this.lastupdatedby = lastupdatedby;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastupdateddate", nullable = false, length = 19)
	public Date getLastupdateddate() {
		return this.lastupdateddate;
	}

	public void setLastupdateddate(Date lastupdateddate) {
		this.lastupdateddate = lastupdateddate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
	public Set getHouses() {
		return this.houses;
	}

	public void setHouses(Set houses) {
		this.houses = houses;
	}

}
