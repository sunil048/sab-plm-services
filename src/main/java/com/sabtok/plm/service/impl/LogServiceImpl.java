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

	private final String ISSUE_CLOSED_LOG = "Closed by Issue model";
	
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

}
