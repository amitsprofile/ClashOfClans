package com.aptmgmt.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
/**
 * Society Model
 * @author Prakash Manwani
 */
@Entity
@Table(name = "society", catalog = "aptmgmt", uniqueConstraints = @UniqueConstraint(columnNames = "socid"))
public class Society implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String socid;
	private String name;
	private String address;
	private int managerid;
	private String contact;
	private int rowstate;
	private int loggedby;
	private Date loggeddate;
	private int lastupdatedby;
	private Date lastupdateddate;
	private Set houses = new HashSet(0);
	private Set buildings = new HashSet(0);

	public Society() {
	}

	public Society(String socid, String name, int managerid, int rowstate, int loggedby, Date loggeddate,
			int lastupdatedby, Date lastupdateddate) {
		this.socid = socid;
		this.name = name;
		this.managerid = managerid;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
	}

	public Society(String socid, String name, String address, int managerid, String contact, int rowstate, int loggedby,
			Date loggeddate, int lastupdatedby, Date lastupdateddate, Set houses, Set buildings) {
		this.socid = socid;
		this.name = name;
		this.address = address;
		this.managerid = managerid;
		this.contact = contact;
		this.rowstate = rowstate;
		this.loggedby = loggedby;
		this.loggeddate = loggeddate;
		this.lastupdatedby = lastupdatedby;
		this.lastupdateddate = lastupdateddate;
		this.houses = houses;
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

	@Column(name = "managerid", nullable = false)
	public int getManagerid() {
		return this.managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "society")
	public Set getHouses() {
		return this.houses;
	}

	public void setHouses(Set houses) {
		this.houses = houses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "society")
	public Set getBuildings() {
		return this.buildings;
	}

	public void setBuildings(Set buildings) {
		this.buildings = buildings;
	}

	@Override
	public String toString() {
		return "Society [id=" + id + ", socid=" + socid + ", name=" + name + ", address=" + address + ", managerid="
				+ managerid + ", contact=" + contact + ", rowstate=" + rowstate + ", loggedby=" + loggedby
				+ ", loggeddate=" + loggeddate + ", lastupdatedby=" + lastupdatedby + ", lastupdateddate="
				+ lastupdateddate + ", houses=" + houses + ", buildings=" + buildings + "]";
	}

}
