/**
 * 
 */
package com.sabtok.plm.controller;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.dao.MyDao;
import com.sabtok.plm.entity.Project;
import com.sabtok.plm.service.ProjectService;
import com.sabtok.plm.util.IDGenerator;

/**
 * @author Sunil
 *
 * ProjectController.java Aug 9, 2020 5:28:16 PM
 */

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@Autowired
	MyDao myDao;
	
	@RequestMapping(value="/details/{projectid}", method=RequestMethod.GET)
	public Project getProjectDetails(@PathVariable("projectid") String projectId,ModelMap map){
		 Project pr = projectService.getProjectdetails(projectId); 
		 /*
		 *
		 * List <Skill>
		 * skillNameList = skillService.getSkillList(); 
		 * if(pr != null){
		 * 
		 * pr.getSkillList().add(new ProjectSkill()); } else { pr = new Project(); }
		 * map.put("skillNameList", skillNameList);//Skill name drop down list.
		 * map.put("project", pr); map.put("ReleaseList",
		 * releaseService.getReleaseListForProject(pr.getProjectName().toUpperCase()));
		 */
		return pr;
	}
	
	
	@GetMapping("/names")
	public List <String> getProjectList(){
		List<String> prName = projectService.getProjectNames();
		if(prName.isEmpty()) // if project module not implementecd then get project names from plm_war
			try {
				prName = myDao.getProjectNameList();
			} catch (SQLException e) {
				e.printStackTrace();
				prName.add("error in project retriving");
			}
		return prName;
		
	}
	
	@GetMapping("/list")
	public List<Project> getAllProjects(){
		return projectService.getProjectList();
	}
	
	@PostMapping("/save")
	public Project registerProject(@RequestBody Project project) {
		project.setProjectId("SAB"+IDGenerator.getProjectId());
		return projectService.saveProject(project);
	}
	
	@PostMapping("/update")
	public Project updateProject(@RequestBody Project project) {
		System.out.println(project);
		return projectService.updateProject(project);
	}
	
}
