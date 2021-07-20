/**
 * 
 */
package com.sabtok.plm.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.sabtok.plm.dao.MyDao;
import com.sabtok.plm.dao.SubtaskDao;
import com.sabtok.plm.dao.TaskDao;
import com.sabtok.plm.entity.SubTask;
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
	
	@Autowired
	SubtaskDao stdao;
	
	@Autowired
	LogService logService;
	
	@Autowired
	MyDao dao;
	
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
		Optional<Task> task = tdao.findById(taskId);
		List<String> subTaskIds = task.get().getSubTasks().stream().map(st -> st.getSubTaskId()).collect(Collectors.toList());
		subTaskIds.add(task.get().getTaskid());
		task.ifPresent(t -> {
		//	t.getSubTasks().stream().map(st -> logService.getLogListByProject())
			//t.setLogList(logService.getLogListByProject(t.getTaskid()));
			t.setLogList(logService.getLogListByProject(subTaskIds));
		});
		return task;
		//return tdao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.TaskService#saveTask(com.sabtok.plm.entity.Task)
	 */
	@Override
	public Task saveTask(Task task) {
		task = tdao.save(task);
		if (task != null) {
			logService.addTaskCreatedLog(task.getTaskid());
		}
		return task;
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.TaskService#closeTask(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean closeTask(String taskId, String closeDate) {
		int result = tdao.closeTask(closeDate, taskId);
		if (result == 1) {
			logService.svaeTaskClosedLog(taskId);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean changetaskStatus(String taskId, String status) {
		int result = tdao.changeTaskStatus(status, taskId);
		if (result == 1) {
			logService.svaeTaskChangesLog(taskId, status);
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.TaskService#changetaskPriority(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean changetaskPriority(String taskId, String priority) {
		int result = tdao.changeTaskPriority(priority, taskId);
		if (result == 1) {
			logService.saveTaskPriorityChangesLog(taskId, priority);
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.TaskService#getTaskStatus()
	 */
	@Override
	public List<String> getTaskStatus() throws SQLException {
		List<String> taskStatus = dao.getTaskStatus();
		return taskStatus;
	}

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.TaskService#getTaskPriorityList()
	 */
	@Override
	public List<String> getTaskPriorityList() throws SQLException {
		List<String> taskPriority = dao.getTaskPriorityList();
		return taskPriority;
	}
	
	public List <Task> getTaskListByStatus(String status){
		List<Task> taskList = tdao.getListByStatus(status);
	//	taskList = taskList.stream().filter(t -> t.getStatus().equals("Closed")).collect(Collectors.toList());
		return taskList;
	}

	@Override
	public Integer getOpenTaskCount() {
		return tdao.getOpenTaskCount();
	}

	@Override
	public Integer getClosedTaskCount() {
		return tdao.getCloedTaskCount();
	}

	@Override
	public Long getTotalTaskCount() {
		return tdao.count();
	}

	@Override
	public Integer getInprogressTaskCount() {
		return tdao.getInprogressTaskCount();
	}

	@Override
	public Integer getHoldTaskCount() {
		return tdao.getHoldTaskCount();
	}

	@Override
	public Integer getNoStatusTaskCount() {
		return tdao.getNoStatusTaskCount();
	}

	@Override
	public List<String> getTaskTypesFromPLM_WAR() {
		try {
			return dao.getTaskTypes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList();
	}

}
