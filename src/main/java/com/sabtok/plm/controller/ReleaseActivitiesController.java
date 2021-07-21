package com.sabtok.plm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sabtok.plm.entity.Release;
import com.sabtok.plm.service.ReleaseActivities;


@Controller
public class ReleaseActivitiesController {

	@Autowired
	ReleaseActivities releaseService;
	
	@RequestMapping(value="/release/generateId",produces="Application/json",method=RequestMethod.GET)
	@ResponseBody
	public String getReleaseId(){
		return releaseService.getReleaseId();
	}
	
	@RequestMapping(value="/release/getReleaseList",produces="Application/json",method=RequestMethod.GET)
	@ResponseBody
	public List<Release> getAllReleaseList(){
		return releaseService.getAllReleases();
	}
	
	@RequestMapping(value="/release/getReleaseListForProject/{projectName}",produces="Application/json",method=RequestMethod.GET)
	@ResponseBody
	public List<Release> getAllReleaseListForProject(@PathVariable("projectName") String projectName){
		return releaseService.getAllReleasesForProject(projectName);
	}
	
	//@RequestMapping(value="/release/create",method=RequestMethod.POST)
	@PostMapping("/release/create")
	@ResponseBody
	public Boolean createReleaseActivity(@RequestBody Release rel) {
		releaseService.createReleaseActivity(rel);
		return true;
	}
	

}
