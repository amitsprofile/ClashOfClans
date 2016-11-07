package com.aptmgmt.entity;

import java.io.Serializable;
import java.util.Date;

public interface Entity extends Serializable
{
    Integer getId();
    
	public Integer getRowstate();

	public Integer getLoggedby();

	public Date getLoggeddate();

	public Integer getLastupdatedby();

	public Date getLastupdateddate();
	
	public void setRowstate(Integer rowstate);

	public void setLoggedby(Integer loggedby);

	public void setLoggeddate(Date loggeddate);

	public void setLastupdatedby(Integer lastupdatedby);

	public void setLastupdateddate(Date lastupdateddate);

}
