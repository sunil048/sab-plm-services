/**
 * 
 */
package com.sabtok.plm.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.entity.Task;
import com.sabtok.plm.service.TaskService;
import com.sabtok.plm.util.IDGenerator;

/**
 * @author Sunil
 *
 * TaskController.java Aug 2, 2020 10:22:41 AM
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	TaskService service;

	@GetMapping("/test")
	public String test() {
		return "Success";
	}
	
	@GetMapping("/list")
	public Object getAllTask() {
		return service.getAllTasks();
	}
	
	@GetMapping("/detail/{taskId}")
	public Object getDetail(@PathVariable String taskId) {
		Assert.notNull(taskId,"No task Id");
		return service.getTaskDetail(taskId);
	}
	
	@PostMapping("/save")
	public Task saveTask(@RequestBody Task task) {
		Task task1 = service.saveTask(task);
		return task1;
	}
	
	@GetMapping("/gettaskid")
	public String generateTaskId() {
		return IDGenerator.prefix.SAB.toString()+IDGenerator.generateTaskId();
	}
	
	@PostMapping("/close")
	public String closeTask(@RequestBody Map<String,String> taskDetails) {
		boolean result = service.closeTask(taskDetails.get("TASK_ID"), taskDetails.get("CLOSE_DATE"));
		if (result)
			return "success";
		return "failed";
			
	}
	
	@PostMapping("/statuschange")
	public String changeTaskStatus(@RequestBody Map<String,String> taskDetails) {
		boolean result = service.changetaskStatus(taskDetails.get("TASK_ID"), taskDetails.get("STATUS"));
		if (result)
			return "success";
		return "failed";
			
	}
	
	@PostMapping("/prioritychange")
	public String changeTaskPriority(@RequestBody Map<String,String> taskDetails) {
		boolean result = service.changetaskPriority(taskDetails.get("TASK_ID"), taskDetails.get("PRIORITY"));
		if (result)
			return "success";
		return "failed";
			
	}
	
	
	@GetMapping("/statuslist")
	public List<String> getTaskStatus() throws SQLException{
		List<String> taskStatus = service.getTaskStatus();
		return taskStatus;
	}
	
	@GetMapping("/prioritylist")
	public List<String> getTaskPriorityList() throws SQLException{
		List<String> taskPriorityList = service.getTaskPriorityList();
		return taskPriorityList;
	}
	
}
