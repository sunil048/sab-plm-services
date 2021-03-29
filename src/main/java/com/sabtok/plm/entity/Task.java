package com.sabtok.plm.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TASKS")
public class Task {

	@Id
	@Column(name="TASK_ID")
	private String taskid;
	
	@Column(name="TASK_NAME")
	private String name;
	
	@Column(name="PRIORITY")
	private String priority;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="WIKIPEDIA")
	private String wikipedia;
	
	public String getWikipedia() {
		return wikipedia;
	}

	public void setWikipedia(String wikipedia) {
		this.wikipedia = wikipedia;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="PROJECT_NAME")
	private String projectName;
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="OPEN_DATE")
	private String openDate;
	
	@Column(name="CLOSED_DATE")
	private String closedDate;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	//@Column(name="TASK_LOGS")
	//@JoinTable(name="tasks_logs") 
	private List<Log> logList = new ArrayList<Log>();

	public List<Log> getLogList() {
		return logList;
	}

	public void setLogList(List<Log> logList) {
		this.logList = logList;
	}

	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", name=" + name + ", priority=" + priority + ", status=" + status
				+ ", wikipedia=" + wikipedia + ", projectName=" + projectName + ", description=" + description
				+ ", openDate=" + openDate + ", closedDate=" + closedDate + ", logList=" + logList + "]";
	}

	

	
}
