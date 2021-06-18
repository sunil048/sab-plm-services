/**
 * 
 */
package com.sabtok.plm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sabtok.plm.entity.Log;

/**
 * @author Sunil
 *
 * LogService.java Aug 11, 2020 3:50:28 PM
 */
@Service
public interface LogService {

	public List<Log> getLogList();
	public List<Log> getLogListByProject(String project);
	public Log saveLog(Log log);
	public Long nextLogRowno();
	public boolean svaeIssueClosedLog(String issueId);
	public boolean svaeTaskClosedLog(String taskId);
	public boolean addTaskCreatedLog(String taskId);
	public boolean svaeTaskChangesLog(String taskId,String status);
	public boolean saveTaskPriorityChangesLog(String taskId,String priority);
	public boolean creatLogAction(String itemId,String itemName);//logger for creation
}
