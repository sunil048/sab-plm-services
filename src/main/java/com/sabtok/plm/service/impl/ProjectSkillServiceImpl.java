package com.sabtok.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sabtok.plm.dao.ProjectDao;
import com.sabtok.plm.dao.ProjectSkillDao;
import com.sabtok.plm.entity.ProjectSkill;
import com.sabtok.plm.service.ProjectSkillService;

@Component
public class ProjectSkillServiceImpl   implements ProjectSkillService {

	@Autowired
	private ProjectSkillDao projectSkillDao;
	
	@Override
	public ProjectSkill saveProjectSkill(ProjectSkill projectSkill) {
		return projectSkillDao.saveAndFlush(projectSkill);
	}

	@Override
	public List<ProjectSkill> getAllProjectSkills() {
		return projectSkillDao.findAll();
	}

	@Override
	public List<ProjectSkill> getAllProjectSkillsForProject(String projectId) {
		return projectSkillDao.findAllProjectSkillByProjectId(projectId);
	}

	@Override
	public int getItemId(String projectId) {
		Long l = projectSkillDao.countByProjectId(projectId);
		int count = l.intValue()+1;
		String itemIdSpace = "0";
		if (count < 9)
			itemIdSpace = "00";
		String itemId = projectId.substring(3, projectId.length())+itemIdSpace+count;
		System.out.println(itemId);
		return Integer.valueOf(itemId);
	}
	
	

}
