package com.sabtok.plm.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EFFORTS")
public class Efforts implements Serializable{

	@Id
	@Column(name="ROW_NO")
	private Long rowNo;
	private String taskId;
	private String taskType;//ISSUE,TASK,REL,SKILL
	private LocalDateTime date;
	private int hours;
	private String comment;
	
	
	
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Efforts(Long rowNo, String taskId, String taskType, LocalDateTime date, int hours,String comment) {
		super();
		this.rowNo = rowNo;
		this.taskId = taskId;
		this.taskType = taskType;
		this.date = date;
		this.hours = hours;
		this.comment = comment;
	}
	public Efforts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getRowNo() {
		return rowNo;
	}
	public void setRowNo(Long rowNo) {
		this.rowNo = rowNo;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	
}
