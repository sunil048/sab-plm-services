/**
 * 
 */
package com.sabtok.plm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.service.ProjectService;

/**
 * @author Sunil
 *
 * ProjectController.java Aug 9, 2020 5:28:16 PM
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@GetMapping("/names")
	public List <String> getProjectList(){
		return projectService.getProjectNames();
	}
	
}
