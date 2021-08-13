package com.sabtok.plm.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.validator.constraints.NotBlank;
//import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="SABPROJECTS")
public class Project implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="PROJECT_ID")
	private String projectId;

	@Column(name="NAME")
   // @NotBlank(message="Please enter project name")
 	private String projectName;
	
	@Column(name="START_DATE")
  //  @NotBlank(message="Please enter strat date")
    private String stratDate;
	
	@Column(name="PREVIOUS_VERSION")
	private Double previousVersion;
	
    @Column(name="CURRENT_VERSION")
    private Double currentVersion;
     
    @Column(name="DESCRIPTION")
    private String description;
   
    @Column(name="NOTES")
    @Lob
    private String notes;
    
    @Column(name="TEST_ENV")
    private String testingEnv;
    
    @Column(name="DEV_ENV")
    @Lob
    private String devEnv;
    
    @Column(name="PROD_ENV")
    @Lob
    private String prodEnv;

	/*@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="PROJECT_SKILLS",joinColumns={@JoinColumn(name="PROJECT_ID")},inverseJoinColumns={@JoinColumn(name="SKILL_ITEM_ID")})
	 private List<ProjectSkill> skillList = new ArrayList<ProjectSkill>();
	
	public List<ProjectSkill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<ProjectSkill> skillList) {
		this.skillList = skillList;
	}*/

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	

	public String getStratDate() {
		return stratDate;
	}

	public void setStratDate(String stratDate) {
		this.stratDate = stratDate;
	}

	public Double getPreviousVersion() {
		return previousVersion;
	}

	public void setPreviousVersion(Double previousVersion) {
		this.previousVersion = previousVersion;
	}

	public Double getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(Double currentVersion) {
		this.currentVersion = currentVersion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(String projectId, String projectName) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
	
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTestingEnv() {
		return testingEnv;
	}

	public void setTestingEnv(String testingEnv) {
		this.testingEnv = testingEnv;
	}

	public String getDevEnv() {
		return devEnv;
	}

	public void setDevEnv(String devEnv) {
		this.devEnv = devEnv;
	}

	public String getProdEnv() {
		return prodEnv;
	}

	public void setProdEnv(String prodEnv) {
		this.prodEnv = prodEnv;
	}

	
	
	
}
