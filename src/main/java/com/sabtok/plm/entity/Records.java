/**
 * 
 */
package com.sabtok.plm.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Sunil
 *
 * Records.java Jun 17, 2021 9:04:30 PM
 */
@Entity
@Table(name="RECORDS")
@JsonIgnoreProperties(value = { "recordContenet","recordBlobContent" })
public class Records implements Serializable{

	@Id
	private Long recordId;
	private String recordName;
	private String recordType;
	private byte[]  recordContenet;
	private Blob recordBlobContent;
	private String filebinaryData;
	
	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getFilebinaryData() {
		return filebinaryData;
	}



	public void setFilebinaryData(String filebinaryData) {
		this.filebinaryData = filebinaryData;
	}



	public Blob getRecordBlobContent() {
		return recordBlobContent;
	}


	public void setRecordBlobContent(Blob recordBlobContent) {
		this.recordBlobContent = recordBlobContent;
	}


	public Long getRecordId() {
		return recordId;
	}
	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	public String getRecordName() {
		return recordName;
	}
	public void setRecordName(String recordName) {
		this.recordName = recordName;
	}
	public String getRecordType() {
		return recordType;
	}
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
	public byte[] getRecordContenet() {
		return recordContenet;
	}
	public void setRecordContenet(byte[] recordContenet) {
		this.recordContenet = recordContenet;
	}
	
	
}
