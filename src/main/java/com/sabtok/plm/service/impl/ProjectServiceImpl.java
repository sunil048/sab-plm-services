/**
 * 
 */
package com.sabtok.plm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabtok.plm.dao.ProjectDao;
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
	
	@Override
	public List<String> getProjectNames() {
		// TODO Auto-generated method stub
		List<String> projectName = new ArrayList<String>();
		projectName.add("PLM");
		projectName.add("PLM-Dev");
		projectName.add("sab-edu");
		return projectName;
	}

}
