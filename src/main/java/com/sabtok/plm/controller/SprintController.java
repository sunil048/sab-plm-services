package com.sabtok.plm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.entity.Sprint;
import com.sabtok.plm.service.SprintServices;
import com.sabtok.plm.util.IDGenerator;

@RestController
@RequestMapping("/sprint")
public class SprintController {

	@Autowired
	SprintServices sprintServ;
	
	@GetMapping("/list")
	public List<Sprint> getSprintList(){
		return 	sprintServ.getAllSprint();
	}
	
	@PostMapping("/save")
	public Sprint saveSprint(@RequestBody Sprint sprint) {
		return sprintServ.saveSprint(sprint);
	}
	
	@GetMapping("/generate-id")
	public String getSprintId() {
		return "SPR"+IDGenerator.getSprintId();
	}
	
	@GetMapping("/details/{sprintId}")
	public Sprint getSprintDetails(@PathVariable ("sprintId") String sprintId) {
		return sprintServ.getSprintDetails(sprintId);
	}
	
	@PostMapping("/update")
	public Sprint updateSprintDetails(@RequestBody Sprint sprint) {
		return sprintServ.updateSprint(sprint);
	}
}
