package com.sabtok.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sabtok.plm.dao.BackupDao;
import com.sabtok.plm.dao.DataBaseBackUpdao;
import com.sabtok.plm.entity.BackUp;
import com.sabtok.plm.entity.DataBaseBackUp;
import com.sabtok.plm.service.BackupService;

@Component
public class BackupServiceImpl implements BackupService {

	@Autowired
	BackupDao backupDao;
	
	@Autowired
	DataBaseBackUpdao dao;
	
	@Override
	public List<? extends BackUp> getAllBackupList() {
		return dao.findAll();
	}

	@Override
	public BackUp savebackup(DataBaseBackUp backUp) {
		return dao.save(backUp);
	}

	@Override
	public BackUp getBackUpDetails(String backupId) {
		return dao.findById(backupId).get();
	}

}
