package com.sabtok.plm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sabtok.plm.entity.Efforts;

@Service
public interface EffortService {

	public String logEfforts(String taskId, String taskType,int hours,String comment);
	public List<Efforts> getEffortsList();
	public Long getTotalEffortForTask(String taskID);
	public Long getTotalEffort();
}
