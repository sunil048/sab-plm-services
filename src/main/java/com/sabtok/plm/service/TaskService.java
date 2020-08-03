/**
 * 
 */
package com.sabtok.plm.service;

import java.util.List;
import java.util.Optional;

import com.sabtok.plm.entity.Task;


/**
 * @author Sunil
 *
 * TaskService.java Aug 2, 2020 10:36:19 AM
 */
public interface TaskService {

	public List <Task> getAllTasks();
	public Optional<Task> getTaskDetail(String taskId);
	
}
