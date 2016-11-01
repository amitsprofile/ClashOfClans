package com.aptmgmt.model;
// Generated Sep 14, 2016 3:22:12 AM by Hibernate Tools 4.3.1.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * House Model
 * @author Prakash Manwani
 */
@Entity
@Cacheable
@Cache(region = "house", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "house", catalog = "aptmgmt")
public class House implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Building building;
	private User userByResidentid;
	private User userByOwnerid;
	private String housenum;
	private String address;
	private String contact;
	private int rowstate;
	private int loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;

	public House() {
	}

	public House(Building building, User userByResidentid, User userByOwnerid, String housenum, int rowstate,
			int loggedby, Date loggeddate) {
		this.building = building;
		this.userByResidentid = userByResidentid;
		this.userByOwnerid = userByOwnerid;
		this.housenum = housenum;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
	}

	public House(Building building, User userByResidentid, User userByOwnerid, String housenum, String address,
			String contact, int rowstate, int loggedby, Date loggeddate, Integer lastupdatedby, Date lastupdateddate) {
		this.building = building;
		this.userByResidentid = userByResidentid;
		this.userByOwnerid = userByOwnerid;
		this.housenum = housenum;
		this.address = address;
		this.contact = contact;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "buildingid", nullable = false)
	@JsonBackReference
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "residentid", nullable = false)
	@JsonBackReference
	public User getUserByResidentid() {
		return this.userByResidentid;
	}

	public void setUserByResidentid(User userByResidentid) {
		this.userByResidentid = userByResidentid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ownerid", nullable = false)
	@JsonBackReference
	public User getUserByOwnerid() {
		return this.userByOwnerid;
	}

	public void setUserByOwnerid(User userByOwnerid) {
		this.userByOwnerid = userByOwnerid;
	}

	@Column(name = "housenum", nullable = false, length = 10)
	public String getHousenum() {
		return this.housenum;
	}

	public void setHousenum(String housenum) {
		this.housenum = housenum;
	}

	@Column(name = "address", length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        House other = (House) object;

        return new EqualsBuilder().append(this.getId(), other.getId())
                .append(this.getHousenum(), other.getHousenum()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).append(getHousenum()).toHashCode();
    }
    
	@Override
	public String toString() {
		return "House [id=" + id + ", building=" + building + ", userByResidentid=" + userByResidentid
				+ ", userByOwnerid=" + userByOwnerid + ", housenum=" + housenum + ", address=" + address
				+ ", contact=" + contact + ", rowstate=" + rowstate + ", loggedby=" + loggedby + ", loggeddate="
				+ loggeddate + ", lastupdatedby=" + lastupdatedby + ", lastupdateddate=" + lastupdateddate + "]";
	}

}
