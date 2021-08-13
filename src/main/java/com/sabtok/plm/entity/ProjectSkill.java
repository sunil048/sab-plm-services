package com.sabtok.plm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//import org.hibernate.validator.constraints.NotEmpty;

//import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "PROJECTSKILLS")
public class ProjectSkill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ITEM_ID",unique=true)
	private Integer itemId;

	@Column(name = "SKILL_NAME")
	private String skillName;
	
	@Column(name = "VERSION")
	private String version;

	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name="PROJECT")
	private String projectId;
	
	@Column(name="PROJECT_VERSION",columnDefinition = "double default 0")
	private Double projectVersion;
	

	public ProjectSkill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getItemId() {
		return itemId;
	}

	public ProjectSkill(Integer itemId,String skillName, String version, String description) {
		super();
		this.itemId = itemId;
		this.skillName = skillName;
		this.version = version;
		this.description = description;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Double getProjectVersion() {
		return projectVersion;
	}

	public void setProjectVersion(Double projectVersion) {
		this.projectVersion = projectVersion;
	}

	@Override
	public String toString() {
		return "ProjectSkill [itemId=" + itemId + ", skillName=" + skillName + ", version="
				+ version + ", description=" + description + "]";
	}

}
