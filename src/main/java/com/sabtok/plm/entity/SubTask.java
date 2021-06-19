/**
 * 
 */
package com.sabtok.plm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

/**
 * @author Sunil
 *
 * SubTask.java Jun 16, 2021 12:32:23 PM
 */
@Entity
@Table(name="SUB_TASKS")
public class SubTask implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUB_TASK_ID")
	private String subTaskId;
	
	
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
	
	@Column(name="PROJECT_NAME")
	private String projectName;

	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="OPEN_DATE")
	private String openDate;
	
	@Column(name="CLOSED_DATE")
	private String closeddate;
	
	/*@ManyToOne
	@JoinColumn(name="TASK_ID",insertable=false,updatable=false)
	private Task task;
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
*/
	
	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
		return closeddate;
	}

	public void setClosedDate(String closedDate) {
		this.closeddate = closedDate;
	}
	

	public String getSubTaskId() {
		return subTaskId;
	}

	public void setSubTaskid(String subTaskid) {
		this.subTaskId = subTaskid;
	}
	
}
