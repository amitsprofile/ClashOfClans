package com.aptmgmt.model;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
/**
 * Society Model
 * @author Prakash Manwani
 */
@Entity
@Cacheable
@Cache(region = "society", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "society", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = "socid"))
public class Society implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Users users;
	private String socid;
	private String name;
	private String address;
	private String contact;
	private int rowstate;
	private int loggedby;
	private Date loggeddate;
	private Integer lastupdatedby;
	private Date lastupdateddate;
	private Set<Building> buildings = new HashSet<Building>(0);

	public Society() {
	}

	public Society(Users users, String socid, String name, int rowstate, int loggedby, Date loggeddate) {
		this.users = users;
		this.socid = socid;
		this.name = name;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
	}

	public Society(Users users, String socid, String name, String address, String contact, int rowstate, int loggedby,
			Date loggeddate, Integer lastupdatedby, Date lastupdateddate, Set<Building> buildings) {
		this.users = users;
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

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "managerid", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "socid", unique = true, nullable = false, length = 10)
	public String getSocid() {
		return this.socid;
	}

	public void setSocid(String socid) {
		this.socid = socid;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "society")
	public Set<Building> getBuildings() {
		return this.buildings;
	}

	public void setBuildings(Set<Building> buildings) {
		this.buildings = buildings;
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

        return new EqualsBuilder().append(this.getId(), other.getId())
                .append(this.getName(), other.getName()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).append(getName()).toHashCode();
    }

	@Override
	public String toString() {
		return "Society [id=" + id + ", users=" + users + ", socid=" + socid + ", name=" + name + ", address=" + address
				+ ", contact=" + contact + ", rowstate=" + rowstate + ", loggedby=" + loggedby + ", loggeddate="
				+ loggeddate + ", lastupdatedby=" + lastupdatedby + ", lastupdateddate=" + lastupdateddate
				+ ", buildings=" + buildings + "]";
	}

}
