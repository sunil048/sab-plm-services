package com.sabtok.plm.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="DOCUMENTS")
public class AttachedFile {

	@Id
	@Column(name="SL_NO")
	private Integer documentNo;
	
	@Column(name="DOCUMENT_NAME")
	private String documentName;
	
	@Column(name="PARENT_ID")
	private String parentId;
	
	@Column(name="FILE_TYPE")
	private String fileType;
	
	@Column(name="UPLOADED_TIME")
	private String uploadedTime;
	
	@Column(name="DOCUMENT")
	@Lob
	private Blob document;
	
	@Column(name="BINARYDATA")
	private byte[] binaryData;
	
	public byte[] getBinaryData() {
		return binaryData;
	}

	public void setBinaryData(byte[] binaryData) {
		this.binaryData = binaryData;
	}

	public Integer getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(Integer documentNo) {
		this.documentNo = documentNo;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUploadedTime() {
		return uploadedTime;
	}

	public void setUploadedTime(String uploadedTime) {
		this.uploadedTime = uploadedTime;
	}

	public Blob getDocument() {
		return document;
	}

	public void setDocument(Blob document) {
		this.document = document;
	}

	public AttachedFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public class FileData {
		
		private String fileName;
		private String contenetTye;
		
		public FileData(String fileName, String contenetTye) {
			super();
			this.fileName = fileName;
			this.contenetTye = contenetTye;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getContenetTye() {
			return contenetTye;
		}

		public void setContenetTye(String contenetTye) {
			this.contenetTye = contenetTye;
		}
		
		
		
		
		
	}
}
