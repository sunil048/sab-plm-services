package com.sabtok.plm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.sabtok.plm.entity.BackUp;

@Entity
public class SVNBackUp extends BackUp {

	@Column(name="REPOSITORY_NAME")
	private String repositoryName;
	
	@Column(name="PROJECTS")
	private String projects;
	

	@Column(name="URL")
	private String url;

	@Override
	public String toString() {
		return "SVNBackUp [repositoryName=" + repositoryName + ", projects=" + projects + ", url=" + url + "]";
	}

	public SVNBackUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
