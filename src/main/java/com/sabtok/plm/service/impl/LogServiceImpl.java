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

/**
 * @author Sunil
 *
 * LogServiceImpl.java Aug 11, 2020 3:52:24 PM
 */
@Service
public class LogServiceImpl implements LogService{

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

}
