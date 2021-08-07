package com.sabtok.plm.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Entity
@Table(name="BACKUPDATA")
public class BackUp implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	private String itemId;
	
	@Column(name="DATE")
	private String date;
	
	@Column(name="ATTACHED_LOGFILE")
	private String attachedLogFileName;
	
	@Column(name="PRIMARY_LOCATION")
	private String primaryLocation;
	
	@Column(name="SECONDRY_LOCATION")
	private String secodryLocation;
	
	@Column(name="DATA_SIZE")
	private String dataSize;

	public String getAttachedLogFileName() {
		return attachedLogFileName;
	}


	public void setAttachedLogFileName(String attachedLogFileName) {
		this.attachedLogFileName = attachedLogFileName;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getPrimaryLocation() {
		return primaryLocation;
	}


	public void setPrimaryLocation(String primaryLocation) {
		this.primaryLocation = primaryLocation;
	}


	public String getSecodryLocation() {
		return secodryLocation;
	}


	public void setSecodryLocation(String secodryLocation) {
		this.secodryLocation = secodryLocation;
	}


	public String getDataSize() {
		return dataSize;
	}


	public void setDataSize(String dataSize) {
		this.dataSize = dataSize;
	}

	public BackUp() {
		super();
	}
	

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}




}
