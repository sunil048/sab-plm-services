/**
 * 
 */
package com.sabtok.plm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabtok.plm.dao.MyDao;
import com.sabtok.plm.dao.ProjectDao;
import com.sabtok.plm.entity.Project;
import java.util.Map;
import com.sabtok.plm.service.ProjectService;

/**
 * @author Sunil
 *
 * ProjectServiceImpl.java Aug 9, 2020 5:30:14 PM
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.ProjectService#getProjectList()
	 */
	@Autowired
	ProjectDao projectdao;
	
	@Autowired
	MyDao myDao;
	
	@Override
	public List<String> getProjectNames() {
		return projectdao.getProjectNameList();
	}

	@Override
	public Project getProjectdetails(String projectId) {
		return projectdao.findById(projectId).get();
	}

	@Override
	public List<Project> getProjectList() {
		return projectdao.findAll();
	}

	@Override
	public Map <String, String> getProjectNameVersion(String projectId) {
		Object proj = myDao.getProjectNameVersion(projectId);
		return null;
	}

	@Override
	public Project saveProject(Project project) {
		return projectdao.save(project);
	}

	@Override
	public Project updateProject(Project project) {
		// TODO Auto-generated method stub
		return projectdao.saveAndFlush(project);
	}

}
