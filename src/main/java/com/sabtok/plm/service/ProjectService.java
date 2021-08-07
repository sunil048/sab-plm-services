/**
 * 
 */
package com.sabtok.plm.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sabtok.plm.entity.Project;

/**
 * @author Sunil
 *
 * ProjectService.java Aug 9, 2020 5:30:04 PM
 */
@Service
public interface ProjectService {

	public List<String> getProjectNames();
	public Project  getProjectdetails(String projectId);
	public List<Project> getProjectList();
	public Map<String,String> getProjectNameVersion(String projectId);
	public Project saveProject(Project project);
	public Project updateProject(Project project);
}
