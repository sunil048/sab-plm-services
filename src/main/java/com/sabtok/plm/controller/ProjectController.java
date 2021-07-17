/**
 * 
 */
package com.sabtok.plm.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.dao.MyDao;
import com.sabtok.plm.entity.Project;
import com.sabtok.plm.service.ProjectService;

/**
 * @author Sunil
 *
 * ProjectController.java Aug 9, 2020 5:28:16 PM
 */
@CrossOrigin("http://localhost:5000")
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
	
}
