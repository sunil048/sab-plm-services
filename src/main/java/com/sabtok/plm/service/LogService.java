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
}
