package com.sabtok.plm.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="LOGS")
public class Log implements Serializable {

	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="SLNO")
	private Long rowNo;
	
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
	
	@Lob
	@Column(name="DETAILS")
	private String details;
	
	@Column(name="FILENAME")
	private String fileName;
	
	@Column(name="SUB_TASK")
	private String subtask;
	
	@Column(name="EFFORTS", columnDefinition = "int(4) default 0")
	private int efforts = 0;
	
	@Column(name="SKILL")
	private String skill;
	
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Log [rowNo=" + rowNo + ", id=" + id + ", date=" + date + ", project=" + project + ", details=" + details
				+ "]";
	}
	public Long getRowNo() {
		return rowNo;
	}
	public void setRowNo(Long rowNo) {
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
	
	public String getSubtask() {
		return subtask;
	}
	public void setSubtask(String subtask) {
		this.subtask = subtask;
	}
	public int getEfforts() {
		return efforts;
	}
	public void setEfforts(int effort) {
		this.efforts = effort;
	}
	public Log(Long rowNo, String id, String date, String project, String details, String fileName) {
		super();
		this.rowNo = rowNo;
		this.id = id;
		this.date = date;
		this.project = project;
		this.details = details;
		this.fileName = fileName;
	}
	public Log(Long rowNo, String id, String date, String project, String details, String fileName, String subtask,
			int effort) {
		super();
		this.rowNo = rowNo;
		this.id = id;
		this.date = date;
		this.project = project;
		this.details = details;
		this.fileName = fileName;
		this.subtask = subtask;
		this.efforts = effort;
	}
	
	
	
}
