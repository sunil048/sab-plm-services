package com.sabtok.plm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="SABPROJECTS")
public class Project {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="SLNO")
	private Integer rowNo;
    
    /*@Column(name="ID")
	private String projectId;*/
    
    @Override
	public String toString() {
		return "Project [rowNo=" + rowNo + ", projectName=" + projectName + ", skillList= ]";
	}

	@Column(name="NAME")
  //  @NotBlank(message="Please enter project name")
 	private String projectName;
    
   /* @Column(name="DESCRIPTION")
    private String description;
   
    @Column(name="START_DATE")
    @NotBlank(message="Please enter strat date")
    private String stratDate;*/
    

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getRowNo() {
		return rowNo;
	}

	public void setRowNo(Integer rowNo) {
		this.rowNo = rowNo;
	}

	/*public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}*/

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/*public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}*/

	/*public String getStratDate() {
		return stratDate;
	}

	public void setStratDate(String stratDate) {
		this.stratDate = stratDate;
	}
*/
	
  
}
