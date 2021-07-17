package com.sabtok.plm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.entity.Efforts;
import com.sabtok.plm.service.EffortService;

@CrossOrigin("*")
@RestController
@RequestMapping("/efforts")
public class EffortController {

	@Autowired
	EffortService effortServ;
	
	@PostMapping("/log")
	public String logEfforts(String taskId, String taskType,int hours,String comment) {
		return effortServ.logEfforts(taskId, taskType, Integer.valueOf(hours), comment);
	}
	
	@GetMapping("/list")
	public List<Efforts> getAllEforts(){
		return effortServ.getEffortsList();
	}
	
	@GetMapping("/totaleffort/{taskID}")
	public String getTotalEffortForTask(@PathVariable("taskID") String taskID) {
		return String.valueOf(effortServ.getTotalEffortForTask(taskID));
	}
	@GetMapping("/totaleffort")
	public String getTotalEffort() {
		return String.valueOf(effortServ.getTotalEffort());
	}
	
}
