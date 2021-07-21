/**
 * 
 */
package com.sabtok.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sabtok.plm.dao.SubtaskDao;
import com.sabtok.plm.entity.SubTask;
import com.sabtok.plm.entity.Task;
import com.sabtok.plm.service.SubTaskService;
import com.sabtok.plm.service.TaskServiceImpl;

/**
 * @author Sunil
 *
 * SubTaskServiceImpl.java Jun 16, 2021 12:24:12 PM
 */
@Service
public class SubTaskServiceImpl implements SubTaskService {

	@Autowired
	private SubtaskDao stDao;
	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.SubTaskService#saveSubTask(com.sabtok.plm.entity.Task)
	 */
	@Override
	public SubTask saveSubTask(SubTask subtask) {
		return stDao.save(subtask);
	}
	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.SubTaskService#getSubTaskList()
	 */
	@Override
	public List<SubTask> getSubTaskList(String taskId) {
		// TODO Auto-generated method stub
		return stDao.getSubTaskListByTaskid(taskId);
	}
	@Override
	public boolean closeTask(String taskId, String closeDate) {
		int result = stDao.closeSubTask(closeDate, taskId);
		if (result == 1) {
			return true;
		}
		return false;
	}
	@Override
	public List<String> getSubTaskNameList(String taskId) {
		return stDao.getSubTaskNameList(taskId);
	}
	
	
}
