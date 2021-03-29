/**
 * 
 */
package com.sabtok.plm.controller;

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
	
}
