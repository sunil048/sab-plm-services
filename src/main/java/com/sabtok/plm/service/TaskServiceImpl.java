/**
 * 
 */
package com.sabtok.plm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sabtok.plm.dao.TaskDao;
import com.sabtok.plm.entity.Task;

/**
 * @author Sunil
 *
 * TaskServiceImpl.java Aug 2, 2020 10:39:38 AM
 */
@Repository
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDao tdao;
	
	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.TaskService#getAllTasks()
	 */
	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return tdao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.TaskService#getTaskDetail()
	 */
	@Override
	public Optional<Task> getTaskDetail(String taskId) {
		// TODO Auto-generated method stub
		return tdao.findById(taskId);
		//return tdao.findAll();
	}

}
