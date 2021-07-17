package com.sabtok.plm.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sabtok.plm.dao.EffortsDao;
import com.sabtok.plm.entity.Efforts;
import com.sabtok.plm.service.EffortService;

@Component
public class EffortServiceImpl implements EffortService{

	@Autowired
	EffortsDao effortsDao;
	
	@Override
	public String logEfforts(String taskId, String taskType,int hours,String comment) {
		// TODO Auto-generated method stub
		Efforts effort = new Efforts(effortsDao.getNextEntry()+1,taskId,taskType,LocalDateTime.now(),hours,comment);
		effortsDao.save(effort);
		return "Effort Logged";
	}

	@Override
	public List<Efforts> getEffortsList() {
		return effortsDao.findAll();
	}

	@Override
	public Long getTotalEffortForTask(String taskID) {
		return effortsDao.getTotalEffortForTaskID(taskID);
	}

}
