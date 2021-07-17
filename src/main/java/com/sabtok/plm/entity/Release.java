package com.sabtok.plm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RELEASES")
public class Release {

	@Id
	@Column(name="RELEASE_ID")
	private String releasedId;
	
	@Column(name="RELEASE_DATE")
	private String date;
	
	@Column(name="PROJECT")
	private String project;
	
	@Column(name="RELEASE_NAME")
	private String releaseName;
	
	@Column(name="RELEASE_VERSION")
	private String version;
	
	@Column(name="PRODUCTION_DATABASE")
	private String productionDataBaseBaseName;
	
	@Column(name="SVN_BACKUP_ID")
	private String svnBackUpId;
	
	@Column(name="DATABASE_BACKUP_ID")
	private String databaseBackUpId;
	
	@Column(name="KNOWN_ISSUES")
	private String knownIssues;
	
	@Column(name="KEY_NOTES")
	private String keyNotes;
	
	@Column(name="DOCCUENTION_ID_PATH")
	private String doccumentationId;
	
	@Column(name="WIKIPEDIA")
	private String wikipedia;
	
	
	public String getKnownIssues() {
		return knownIssues;
	}
	public void setKnownIssues(String knownIssues) {
		this.knownIssues = knownIssues;
	}
	
	
	public String getKeyNotes() {
		return keyNotes;
	}
	public void setKeyNotes(String keyNotes) {
		this.keyNotes = keyNotes;
	}
	
	public String getDoccumentationId() {
		return doccumentationId;
	}
	public void setDoccumentationId(String doccumentationId) {
		this.doccumentationId = doccumentationId;
	}
	
	public String getWikipedia() {
		return wikipedia;
	}
	@Override
	public String toString() {
		return "Release [realeseId=" + releasedId + ", date=" + date + ", project=" + project + ", releaseName="
				+ releaseName + ", version=" + version + ", database=" + productionDataBaseBaseName + ", svnBackUpId=" + svnBackUpId
				+ ", databaseBackUpId=" + databaseBackUpId + ", knownIssues=" + knownIssues + ", keyNotes=" + keyNotes
				+ ", doccumentationId=" + doccumentationId + ", wikipedia=" + wikipedia + "]";
	}
	public void setWikipedia(String wikipedia) {
		this.wikipedia = wikipedia;
	}
	
	public String getReleasedId() {
		return releasedId;
	}
	public void setReleaseId(String realeseId) {
		this.releasedId = realeseId;
	}
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getProductionDataBaseBaseName() {
		return productionDataBaseBaseName;
	}
	public void setProductionDataBaseBaseName(String productionDataBaseBaseName) {
		this.productionDataBaseBaseName = productionDataBaseBaseName;
	}
	
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	

	public String getReleaseName() {
		return releaseName;
	}
	public void setReleaseName(String releaseName) {
		this.releaseName = releaseName;
	}
	
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getSvnBackUpId() {
		return svnBackUpId;
	}
	public void setSvnBackUpId(String svnBackUpId) {
		this.svnBackUpId = svnBackUpId;
	}
	
	
	public String getDatabaseBackUpId() {
		return databaseBackUpId;
	}
	public void setDatabaseBackUpId(String databaseBackUpId) {
		this.databaseBackUpId = databaseBackUpId;
	}

}
