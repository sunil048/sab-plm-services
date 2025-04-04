/**
 * 
 */
package com.sabtok.plm.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.sabtok.plm.entity.BucketTask;
import org.springframework.data.jpa.repository.Query;

import com.sabtok.plm.entity.Task;


/**
 * @author Sunil
 *
 * TaskService.java Aug 2, 2020 10:36:19 AM
 */
public interface TaskService {

	public List<String> getTaskTypesFromPLM_WAR();
	public List <Task> getAllTasks();
	public List <Task> getAllTasksForProject(String projectName);
	public Optional<Task> getTaskDetail(String taskId);
	public Task saveTask(Task task);
	public boolean closeTask(String taskId,String closeDate);
	// Gives all defined task status
	public List<String> getTaskStatus() throws SQLException;
	public List<String> getTaskPriorityList() throws SQLException;
	/**
	 * @param taskId
	 * @param status
	 * @return
	 */
	boolean changetaskStatus(String taskId, String status);
	boolean changetaskPriority(String taskId, String priority);
	List <Task> getTaskListByStatus(String status);
	public Long getTotalTaskCount();
	public Integer getOpenTaskCount();
	public Integer getClosedTaskCount();
	public Integer getInprogressTaskCount();
	public Integer getHoldTaskCount();
	public Integer getNoStatusTaskCount();
	public List<Task> getAllTaskExcludingClosed();
	
}
