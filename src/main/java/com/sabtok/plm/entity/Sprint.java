package com.sabtok.plm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="SPRINTS")
public class Sprint {

	@Id
	private String sprintId;
	private String sprintName;
	private String startDate;
	private String completionDate;
	
	@Lob
	private String planDetails;
	
	@Lob
	private String momDeatils;
	
	@Lob
	private String workSpace;
	
	public Sprint() {
		
	}

	public String getSprintId() {
		return sprintId;
	}

	public void setSprintId(String sprintId) {
		this.sprintId = sprintId;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public String getPlanDetails() {
		return planDetails;
	}

	public void setPlanDetails(String planDetails) {
		this.planDetails = planDetails;
	}

	public String getMomDeatils() {
		return momDeatils;
	}

	public void setMomDeatils(String momDeatils) {
		this.momDeatils = momDeatils;
	}

	public String getWorkSpace() {
		return workSpace;
	}

	public void setWorkSpace(String workSpace) {
		this.workSpace = workSpace;
	}
	
	
}
