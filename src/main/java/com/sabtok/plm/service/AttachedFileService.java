package com.sabtok.plm.service;

import java.sql.Blob;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sabtok.plm.entity.AttachedFile;


@Component("attachedFileService")
public interface AttachedFileService {

	public AttachedFile saveAttachement(AttachedFile file);
	
	/*public Blob getBlob(byte[] content);*/
	
	public Optional<AttachedFile>  downLoadAttachement(Integer documentNo);
	public Optional<AttachedFile>  downLoadAttachement1(String parentId,String documentName);
	
}
