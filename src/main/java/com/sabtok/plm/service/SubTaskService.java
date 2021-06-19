/**
 * 
 */
package com.sabtok.plm.service;

import java.util.List;

import com.sabtok.plm.entity.SubTask;
import com.sabtok.plm.entity.Task;

/**
 * @author Sunil
 *
 * SubTaskService.java Jun 16, 2021 12:25:22 PM
 */
public interface SubTaskService {

	public SubTask saveSubTask(SubTask task);
	List<SubTask> getSubTaskList(String taskId);
	public boolean closeTask(String taskId,String closeDate);
}
