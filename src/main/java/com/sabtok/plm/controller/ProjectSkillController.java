package com.sabtok.plm.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.dao.MyDao;
import com.sabtok.plm.entity.Project;
import com.sabtok.plm.entity.ProjectSkill;
import com.sabtok.plm.service.ProjectSkillService;

@RestController
@RequestMapping("/project-skill")
public class ProjectSkillController {

	@Autowired
	private ProjectSkillService projectSkillService;
	
	@Autowired
	private MyDao mydao;
	
	@PostMapping("/save1")
	public String addSkillToProject1(@RequestBody Map <String,String> data) {
		System.out.println(data);
		return "success";
	}
	
	@PostMapping("/save")
	public ProjectSkill addSkillToProject(@RequestBody ProjectSkill requestBody) {
		System.out.println(requestBody);
		return projectSkillService.saveProjectSkill(requestBody);
	}
	
	@GetMapping("/list")
	public List<ProjectSkill> getAllProjectSkills(){
		return projectSkillService.getAllProjectSkills();
	}
	
	@GetMapping("/list/{projectID}")
	public List<ProjectSkill> getAllProjectSkillsForProject(@PathVariable("projectID") String projectID){
		return projectSkillService.getAllProjectSkillsForProject(projectID);
	}
	
	@RequestMapping(value="/name-version/{projectid}", method=RequestMethod.GET)
	public Object getProjectDetailsForId(@PathVariable("projectid") String proId){
		Project project = mydao.getProjectNameVersion(proId);
		Map <String, Object> getProjectNameVersion = new LinkedHashMap();
		getProjectNameVersion.put("ITEMID", projectSkillService.getItemId(proId));
		getProjectNameVersion.put("PROJECT_ID", project.getProjectId());
		getProjectNameVersion.put("PROJECT_ID", project.getProjectId());
		getProjectNameVersion.put("NAME", project.getProjectName());
		getProjectNameVersion.put("CURRENT_VERSION", project.getCurrentVersion());
		return getProjectNameVersion;
	}
}
