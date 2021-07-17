/**
 * 
 */
package com.sabtok.plm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.entity.SubTask;
import com.sabtok.plm.entity.Task;
import com.sabtok.plm.service.SubTaskService;
import com.sabtok.plm.util.DateUtils;
import com.sabtok.plm.util.IDGenerator;

/**
 * @author Sunil
 *
 * SubTaskController.java Jun 16, 2021 3:50:14 PM
 */

@RestController
@RequestMapping("/subtask")
public class SubTaskController {
	
	@Autowired
	private SubTaskService subTaskServ;
	
	@GetMapping("/getsubtaskid")
	public String generateSubTaskId() {
		return IDGenerator.getUUID().toString();
	}
	 //
	
	@PostMapping("/save")
	public SubTask saveTask(@RequestBody SubTask subtask) {
		SubTask task1 = subTaskServ.saveSubTask(subtask);
		return task1;
	}
	
	@GetMapping("/getsubtaskid/{TaskID}")
	List <SubTask> getSubTaskList(@PathVariable("TaskID") String taskId){
		return subTaskServ.getSubTaskList(taskId);
	}
	
	@PostMapping("/close")
	public String closeTask(@RequestBody Map<String,String> taskDetails) {
		boolean result = subTaskServ.closeTask(taskDetails.get("SUB_TASK_ID"), DateUtils.getDateString());
		if (result)
			return "success";
		return "failed";
			
	}
}
