package com.sabtok.plm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sabtok.plm.entity.ProjectSkill;

@Service
public interface ProjectSkillService {

	public ProjectSkill saveProjectSkill(ProjectSkill projectSkill);
	public List<ProjectSkill> getAllProjectSkills();
	public List<ProjectSkill> getAllProjectSkillsForProject(String projectId);
	public int getItemId(String projectId);
	
}
