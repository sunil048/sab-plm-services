/**
 * 
 */
package com.sabtok.plm.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.dao.MyDao;
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
	
	@Autowired
	MyDao myDao;
	
	@GetMapping("/names")
	public List <String> getProjectList(){
		List<String> prName = projectService.getProjectNames();
		if(prName.isEmpty())
			try {
				prName = myDao.getProjectNameList();
			} catch (SQLException e) {
				e.printStackTrace();
				prName.add("error in project retriving");
			}
		return prName;
		
	}
	
}
