/**
 * 
 */
package com.sabtok.plm.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author Sunil
 *
 * Issue.java Aug 5, 2020 7:59:40 PM
 */
@Entity
@Table(name="PROJECT_EXCEPTIONS")
public class Issue {

	@Id
	@Column(name="DOCID")
	private long docId;
	
	@Column(name="DOCUMENT")
	@Lob
	private Blob document;

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public Blob getDocument() {
		return document;
	}

	public void setDocument(Blob document) {
		this.document = document;
	}
	
	
}
