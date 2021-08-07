package com.sabtok.plm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.sabtok.plm.entity.BackUp;

@Entity
public class DataBaseBackUp extends BackUp {

	@Column(name="DATABASE_NAME")
	private String databaseName;
	
	@Column(name="TABLECOUNT")
	private Integer tablesNo;
	
	@Column(name="DETAILS")
	private String details;

	public DataBaseBackUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public Integer getTablesNo() {
		return tablesNo;
	}

	public void setTablesNo(Integer tablesNo) {
		this.tablesNo = tablesNo;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
