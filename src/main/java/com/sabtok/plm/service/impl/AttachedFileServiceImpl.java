package com.sabtok.plm.service.impl;

import java.sql.Blob;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.dao.AttachedFileDAO;
import com.sabtok.plm.entity.AttachedFile;
import com.sabtok.plm.entity.Task;
import com.sabtok.plm.service.AttachedFileService;

@Repository
public class AttachedFileServiceImpl implements AttachedFileService{

	@Autowired
	AttachedFileDAO attachedFiledao;

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.AttachedFileService#downLoadAttachement(java.lang.String)
	 */
	@Override
	public Optional<AttachedFile> downLoadAttachement(Integer documentNo) {
		// TODO Auto-generated method stub
		return attachedFiledao.findById(documentNo);
		
	}
	
	/*
	@Override
	public void saveAttachement(AttachedFile file) {
		
		//String status = attachedFiledao.saveFile(file);
		
		
	}

	@Override
	public Blob getBlob(byte[] content) {
		return attachedFiledao.getBlob(content);
	}

	@Override
	public AttachedFile downLoadAttachement(String fileName) {
		
		return attachedFiledao.getFile(fileName);
		
	}*/

}
