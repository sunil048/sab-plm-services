package com.sabtok.plm.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="LOGS")
public class Log {

	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="SLNO")
	private Integer rowNo;
	
	@Column(name="ID")
	private String id;
	
	@Column(name="DATE")
	private String date;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Column(name="PROJECT")
	private String project;
	
	@Column(name="DETAILS")
	private String details;
	
	@Column(name="FILENAME")
	private String fileName;
	

	@Override
	public String toString() {
		return "Log [rowNo=" + rowNo + ", id=" + id + ", date=" + date + ", project=" + project + ", details=" + details
				+ "]";
	}
	public Integer getRowNo() {
		return rowNo;
	}
	public void setRowNo(Integer rowNo) {
		this.rowNo = rowNo;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
