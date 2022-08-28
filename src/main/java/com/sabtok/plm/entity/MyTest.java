package com.sabtok.plm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyTests")
public class MyTest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MEETING_ID")
	private String meetingId;
	
	@Column(name = "TEST_DATE")
	private String testDate;
	
	@Column(name = "TEST_NAME")
	private String testName;
	
	@Column(name = "TEST_TYPE")
	private String testType;
	
	@Column(name = "URL")
	private String url;
	
	@Column(name = "SKILL")
	private String skill;
	
	@Column(name = "TOTAL_MARKES")
	private Integer totalMarkes;
	
	@Column(name = "MARKS_Scored")
	private Integer marksScored;
	
	@Column(name = "PERCENTAGE")
	private Double percentage;
	
	@Column(name = "STUDENT")
	private String student;
	
	@Column(name =  "NO_OF_ATTEMPTES")
	private Integer numOfAttemptes;
	
	@Column(name = "RESULT")
	private Boolean resulte;
	
	//Hour. mins
	@Column(name = "DURATION")
	private Double duration;
	
	
	public MyTest() {
			}

	public String getMeetingId() {
		return meetingId;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Integer getTotalMarkes() {
		return totalMarkes;
	}

	public void setTotalMarkes(Integer totalMarkes) {
		this.totalMarkes = totalMarkes;
	}

	public Integer getMarksScored() {
		return marksScored;
	}

	public void setMarksScored(Integer marksScored) {
		this.marksScored = marksScored;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public Integer getNumOfAttemptes() {
		return numOfAttemptes;
	}

	public void setNumOfAttemptes(Integer numOfAttemptes) {
		this.numOfAttemptes = numOfAttemptes;
	}

	public Boolean getResulte() {
		return resulte;
	}

	public void setResulte(Boolean resulte) {
		this.resulte = resulte;
	}

	@Override
	public String toString() {
		return "MyTest [meetingId=" + meetingId + ", testDate=" + testDate + ", testName=" + testName + ", testType="
				+ testType + ", url=" + url + ", skill=" + skill + ", totalMarkes=" + totalMarkes + ", marksScored="
				+ marksScored + ", percentage=" + percentage + ", student=" + student + ", numOfAttemptes="
				+ numOfAttemptes + ", resulte=" + resulte + ",duration=" + duration+"]";
	}

		}
	
	

