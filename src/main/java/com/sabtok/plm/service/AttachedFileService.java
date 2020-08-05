package com.sabtok.plm.service;

import java.sql.Blob;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabtok.plm.entity.AttachedFile;


@Service
public interface AttachedFileService {

	/*public void saveAttachement(AttachedFile file);
	
	public Blob getBlob(byte[] content);*/
	
	public Optional<AttachedFile>  downLoadAttachement(Integer documentNo);
	
}
