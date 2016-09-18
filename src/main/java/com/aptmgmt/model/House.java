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
	private Society society;
	private String housenum;
	private String ownername;
	private String address;
	private String contact;
	private String password;
	private int rowstate;
	private int loggedby;
	private Date loggeddate;
	private int lastupdatedby;
	private Date lastupdateddate;

	public House() {
	}

	public House(Building building, Society society, String housenum, String ownername, String password, int rowstate,
			int loggedby, Date loggeddate, int lastupdatedby, Date lastupdateddate) {
		this.building = building;
		this.society = society;
		this.housenum = housenum;
		this.ownername = ownername;
		this.password = password;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
	}

	public House(Building building, Society society, String housenum, String ownername, String address, String contact,
			String password, int rowstate, int loggedby, Date loggeddate, int lastupdatedby, Date lastupdateddate) {
		this.building = building;
		this.society = society;
		this.housenum = housenum;
		this.ownername = ownername;
		this.address = address;
		this.contact = contact;
		this.password = password;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buildingid", nullable = false)
	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socid", nullable = false)
	public Society getSociety() {
		return this.society;
	}

	public void setSociety(Society society) {
		this.society = society;
	}

	@Column(name = "housenum", nullable = false, length = 10)
	public String getHousenum() {
		return this.housenum;
	}

	public void setHousenum(String housenum) {
		this.housenum = housenum;
	}

	@Column(name = "ownername", nullable = false, length = 45)
	public String getOwnername() {
		return this.ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
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

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "House [id=" + id + ", building=" + building + ", society=" + society + ", housenum=" + housenum
				+ ", ownername=" + ownername + ", address=" + address + ", contact=" + contact + ", password="
				+ password + ", rowstate=" + rowstate + ", loggedby=" + loggedby + ", loggeddate=" + loggeddate
				+ ", lastupdatedby=" + lastupdatedby + ", lastupdateddate=" + lastupdateddate + "]";
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

}
