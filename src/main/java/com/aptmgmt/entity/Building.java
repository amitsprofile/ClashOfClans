package com.aptmgmt.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
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
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Building Entity
 * 
 * @author Prakash Manwani
 */
@javax.persistence.Entity
@Cacheable
@Cache(region = "building", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "building", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = "buildingid"))
public class Building implements Entity {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Society society;
	private String buildingid;
	private String name;
	private String address;
	private Integer secretaryid;
	private String contact;
	private Integer rowstate;
	private Integer loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;
	private Set<House> houses = new HashSet<House>(0);

	public Building() {
	}

	public Building(Society society, String buildingid, String name, Integer secretaryid, Integer rowstate, Integer loggedby,
			Date loggeddate) {
		this.society = society;
		this.buildingid = buildingid;
		this.name = name;
		this.secretaryid = secretaryid;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
	}

	public Building(Society society, String buildingid, String name, String address, Integer secretaryid, String contact,
			Integer rowstate, Integer loggedby, Date loggeddate, Integer lastupdatedby, Date lastupdateddate,
			Set<House> houses) {
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
	@Override
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socid", nullable = false)
	@JsonBackReference
	public Society getSociety() {
		return this.society;
	}

	@Column(name = "buildingid", unique = true, nullable = false, length = 10)
	public String getBuildingid() {
		return this.buildingid;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	@Column(name = "address", length = 45)
	public String getAddress() {
		return this.address;
	}

	@Column(name = "secretaryid", nullable = false)
	public Integer getSecretaryid() {
		return this.secretaryid;
	}

	@Column(name = "contact", length = 45)
	public String getContact() {
		return this.contact;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
	@JsonManagedReference
	public Set<House> getHouses() {
		return this.houses;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Building other = (Building) object;

		return new EqualsBuilder().append(this.getId(), other.getId()).append(this.getName(), other.getName())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getName()).toHashCode();
	}

	@Override
	public String toString() {
		return "Building [id=" + id + ", buildingid=" + buildingid + ", name=" + name + ", address=" + address
				+ ", secretaryid=" + secretaryid + ", contact=" + contact + ", rowstate=" + rowstate + ", loggedby="
				+ loggedby + ", loggeddate=" + loggeddate + ", lastupdatedby=" + lastupdatedby + ", lastupdateddate="
				+ lastupdateddate + "]";
	}

	public void setSociety(Society society) {
		this.society = society;
	}

	public void setBuildingid(String buildingid) {
		this.buildingid = buildingid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setSecretaryid(Integer secretaryid) {
		this.secretaryid = secretaryid;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}
}
