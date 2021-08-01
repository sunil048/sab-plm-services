package com.sabtok.plm.service;

import java.util.List;

import com.sabtok.plm.entity.BackUp;
import com.sabtok.plm.entity.DataBaseBackUp;

public interface BackupService {

	public List<? extends BackUp> getAllBackupList();
	public BackUp savebackup(DataBaseBackUp backUp);
	public BackUp getBackUpDetails(String backupId);
}
