package com.sabtok.plm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ISSUES")
public class Issue implements Serializable{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="SLNO")
		private Integer rowNo;
	    
		
	    @Column(name="ISSUEID")
		private String issueID;
	    
	 
	    @Column(name="ISSUE_DATE")
	    private String issueDate;
	    
	    @Column(name="PROJECT")
	    private String project;
	    
	    @Column(name="ISSUE_TYPE")
	    private String issueType;
	    
	    @Column(name="SKILL")
	    private String skill;
	    
	    @Column(name="PRIORITY")
	    private String priority;
	    
	
	    @Column(name="FILE_NAME")
	    private String fileName;
	    
	    @Column(name="DESCRIPTION")
	    private String description;
	    
	    @Column(name="ACTION_TAKEN")
	    private String actionTaken;
	    
	   
	    @Column(name="CLOSED_DATE")
	    private String closedDate;
	    
	    @Column(name="RELATED_ISSUE")
	    private String relatedIssue;
	    
	    
	    @Column(name = "ISSUE_STATUS",nullable=false)
	    private boolean isClosed = false;
	    
	    @JsonIgnore
	    private String fileData;
	    
	    
	    public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getProject() {
			return project;
		}
		public void setProject(String project) {
			this.project = project;
		}
		public String getIssueType() {
			return issueType;
		}
		public void setIssueType(String issueType) {
			this.issueType = issueType;
		}
		public String getSkill() {
			return skill;
		}
		public void setSkill(String skill) {
			this.skill = skill;
		}

		
	    public Issue(){
	        
	    }
	    public String getIssueID() {
	        return issueID;
	    }

	    public void setIssueID(String issueID) {
	        this.issueID = issueID;
	    }

	    public String getIssueDate() {
	        return issueDate;
	    }

	    public void setIssueDate(String issueDate) {
	        this.issueDate = issueDate;
	    }

	    public String getPriority() {
	        return priority;
	    }

	    public void setPriority(String priority) {
	        this.priority = priority;
	    }


	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getActionTaken() {
	        return actionTaken;
	    }

	    public void setActionTaken(String actionTaken) {
	        this.actionTaken = actionTaken;
	    }

	  
		public Integer getRowNo() {
			return rowNo;
		}
		public void setRowNo(Integer rowNo) {
			this.rowNo = rowNo;
		}
	
		@Override
		public String toString() {
			return "Issue [rowNo=" + rowNo + ", issueID=" + issueID + ", issueDate=" + issueDate + ", project="
					+ project + ", issueType=" + issueType + ", skill=" + skill + ", priority=" + priority
					+ ", fileName=" + fileName + ", description=" + description + ", actionTaken=" + actionTaken + "]";
		}
		public String getClosedDate() {
			return closedDate;
		}
		public void setClosedDate(String closeDate) {
			this.closedDate = closeDate;
		}
		public String getRelatedIssue() {
			return relatedIssue;
		}
		public void setRelatedIssue(String relatedIssue) {
			this.relatedIssue = relatedIssue;
		}
		public String getFileData() {
			return fileData;
		}
		public void setFileData(String fileData) {
			this.fileData = fileData;
		}
		public boolean isClosed() {
			return isClosed;
		}
		public void setClosed(boolean isClosed) {
			this.isClosed = isClosed;
		}
}
