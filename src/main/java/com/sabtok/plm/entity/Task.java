package com.sabtok.plm.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TASKS")
public class Task {

	@Id
	@Column(name="TASK_ID")
	private String taskid;
	
	@Column(name="TASK_NAME")
	private String name;
	
	@Column(name="TASK_TYPE")
	private String taskType;
	
	@Column(name="PRIORITY")
	private String priority;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="WIKIPEDIA")
	private String wikipedia;
	
	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

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
	
//	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	//@Column(name="TASK_LOGS")
	//@JoinTable(name="tasks_logs") 
	@Transient
	private List<Log> logList = new ArrayList<Log>();

	public List<Log> getLogList() {
		return logList;
	}

	public void setLogList(List<Log> logList) {
		this.logList = logList;
	}

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="TASK_ID",insertable=false,updatable=false)
	private List<SubTask> subTasks = new ArrayList();
	
	public List<SubTask> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(List<SubTask> subTasks) {
		this.subTasks = subTasks;
	}

	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", name=" + name + ",taskType="+ taskType +", priority=" + priority + ", status=" + status
				+ ", wikipedia=" + wikipedia + ", projectName=" + projectName + ", description=" + description
				+ ", openDate=" + openDate + ", closedDate=" + closedDate + ", logList=" + logList + "]";
	}

	

	
}
