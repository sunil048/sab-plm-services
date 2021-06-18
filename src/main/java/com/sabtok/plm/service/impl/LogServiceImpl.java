/**
 * 
 */
package com.sabtok.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabtok.plm.dao.Logdao;
import com.sabtok.plm.entity.Log;
import com.sabtok.plm.service.LogService;
import com.sabtok.plm.util.DateUtils;
import com.sabtok.plm.util.IDGenerator;

/**
 * @author Sunil
 *
 * LogServiceImpl.java Aug 11, 2020 3:52:24 PM
 */
@Service
public class LogServiceImpl implements LogService{

	private final String ISSUE_CLOSED_LOG = "Closed by Issue Model";
	private final String TASK_CLOSED_LOG = "Closed by Task Model";
	private final String TASK_CREATED_LOG = "CREATED by Task Model";
	private final String TASK_STATUS_CHANGED_LOG = "Status Changed to ";
	private final String TASK_PRIORITY_CHANGED_LOG = "Priority Changed to ";
	
	@Autowired
	private Logdao logDao;
	
	@Override
	public List<Log> getLogList() {
		return logDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.LogService#saveLog(com.sabtok.plm.entity.Log)
	 */
	@Override
	public Log saveLog(Log log) {
		log.setId(IDGenerator.getUUID().toString());
		return logDao.save(log);
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.LogService#logCount()
	 */
	@Override
	public Long nextLogRowno() {
		long totalLogsCount = logDao.nextLogRowno();
		return totalLogsCount+1;
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.LogService#getLogList(java.lang.String)
	 */
	@Override
	public List<Log> getLogListByProject(String project) {
		return logDao.getLogListByProject(project);
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.LogService#svaeIssueClosedLog(java.lang.String)
	 */
	@Override
	public boolean svaeIssueClosedLog(String issueId) { // issueId ---> project
		Log log  = new Log(Integer.valueOf(nextLogRowno().toString()), IDGenerator.getUUID().toString(), DateUtils.getDateString(), issueId, ISSUE_CLOSED_LOG,"");
		try {
			saveLog(log);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.LogService#svaeTaskClosedLog(java.lang.String)
	 */
	@Override
	public boolean svaeTaskClosedLog(String taskId) {
		Log log  = new Log(Integer.valueOf(nextLogRowno().toString()), IDGenerator.getUUID().toString(), DateUtils.getDateString(), taskId, TASK_CLOSED_LOG,"");
		try {
			saveLog(log);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.LogService#addTaskCreatedLog(java.lang.String)
	 */
	@Override
	public boolean addTaskCreatedLog(String taskId) {
		Log log  = new Log(Integer.valueOf(nextLogRowno().toString()), IDGenerator.getUUID().toString(), DateUtils.getDateString(), taskId, TASK_CREATED_LOG,"");
		try {
			saveLog(log);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.LogService#svaeTaskChangesLog(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean svaeTaskChangesLog(String taskId, String status) {
		Log log  = new Log(Integer.valueOf(nextLogRowno().toString()), IDGenerator.getUUID().toString(), DateUtils.getDateString(), taskId, TASK_STATUS_CHANGED_LOG+status,"");
		try {
			saveLog(log);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.LogService#saveTaskPriorityChangesLog(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean saveTaskPriorityChangesLog(String taskId, String priority) {
		Log log  = new Log(Integer.valueOf(nextLogRowno().toString()), IDGenerator.getUUID().toString(), DateUtils.getDateString(), taskId, TASK_PRIORITY_CHANGED_LOG+priority,"");
		try {
			saveLog(log);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean creatLogAction(String itemId, String itemName) {
		Log log  = new Log(Integer.valueOf(nextLogRowno().toString()), IDGenerator.getUUID().toString(), DateUtils.getDateString(), itemId, itemName+" created","");
		try {
			saveLog(log);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	
}
