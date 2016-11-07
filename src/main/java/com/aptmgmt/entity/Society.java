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
 * Society Entity
 * 
 * @author Prakash Manwani
 */
@javax.persistence.Entity
@Cacheable
@Cache(region = "society", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "society", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = "socid"))
public class Society implements Entity {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private String socid;
	private String name;
	private String address;
	private String contact;
	private Integer rowstate;
	private Integer loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;
	private Set<Building> buildings = new HashSet<Building>(0);

	public Society() {
	}

	public Society(User user, String socid, String name, Integer rowstate, Integer loggedby, Date loggeddate) {
		this.user = user;
		this.socid = socid;
		this.name = name;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
	}

	public Society(User user, String socid, String name, String address, String contact, Integer rowstate, Integer loggedby,
			Date loggeddate, Integer lastupdatedby, Date lastupdateddate, Set<Building> buildings) {
		this.user = user;
		this.socid = socid;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.buildings = buildings;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "managerid", nullable = false)
	@JsonBackReference
	public User getUser() {
		return this.user;
	}

	@Column(name = "socid", unique = true, nullable = false, length = 10)
	public String getSocid() {
		return this.socid;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	@Column(name = "address", length = 45)
	public String getAddress() {
		return this.address;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "society")
	@JsonManagedReference
	public Set<Building> getBuildings() {
		return this.buildings;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Society other = (Society) object;

		return new EqualsBuilder().append(this.getId(), other.getId()).append(this.getName(), other.getName())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).append(getName()).toHashCode();
	}

	@Override
	public String toString() {
		return "Society [id=" + id + ", socid=" + socid + ", name=" + name + ", address=" + address + ", contact="
				+ contact + ", rowstate=" + rowstate + ", loggedby=" + loggedby + ", loggeddate=" + loggeddate
				+ ", lastupdatedby=" + lastupdatedby + ", lastupdateddate=" + lastupdateddate + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSocid(String socid) {
		this.socid = socid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
	}
}
