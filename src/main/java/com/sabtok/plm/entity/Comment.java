package com.sabtok.plm.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="COMMENTS")
public class Comment {

	@Id
	@Column(name="ID")
	private String id;
		
	@Column(name="DATE")
	private String date;
	
	@Column(name="PROJECT")
	private String project;
	
	@Lob
	@Column(name="DETAILS")
	private String details;
	
	@Column(name="FILENAME")
	private String fileName;
		
	@Column(name="EFFORT", columnDefinition = "int(4) default 0")
	private int effort = 0;

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getEffort() {
		return effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
	}

	public Comment(String id, String date, String project, String details, String fileName, int effort) {
		super();
		this.id = id;
		this.date = date;
		this.project = project;
		this.details = details;
		this.fileName = fileName;
		this.effort = effort;
	}
	
	public Comment() {
		
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", date=" + date + ", project=" + project + ", details=" + details + ", fileName="
				+ fileName + ", effort=" + effort + "]";
	}
	
	
	
}
