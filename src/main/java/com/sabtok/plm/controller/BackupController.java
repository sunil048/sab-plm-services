package com.sabtok.plm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.entity.BackUp;
import com.sabtok.plm.entity.DataBaseBackUp;
import com.sabtok.plm.service.BackupService;
import com.sabtok.plm.util.IDGenerator;

@RestController
@RequestMapping("/backup")
public class BackupController {

	@Autowired
	BackupService backupService;
	
	@GetMapping("/list")
	public List<? extends BackUp> getBackUpList() {
		return backupService.getAllBackupList();
	}
	
	@PostMapping("/save")
	public BackUp saveBackup(@RequestBody DataBaseBackUp backup) {
		backup.setItemId("SAB"+IDGenerator.getBackItemId());
		return backupService.savebackup(backup);
	}
	
	@GetMapping("/details/{backupId}")
	public BackUp getDataBaseDetails(@PathVariable("backupId") String backupId) {
		return backupService.getBackUpDetails(backupId);
	}
}
