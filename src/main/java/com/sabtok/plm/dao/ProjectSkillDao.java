package com.sabtok.plm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabtok.plm.entity.ProjectSkill;

public interface ProjectSkillDao extends JpaRepository<ProjectSkill, String> {

	public List<ProjectSkill> findAllProjectSkillByProjectId(String project);
	public long countByProjectId(String project);
}
