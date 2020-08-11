/**
 * 
 */
package com.sabtok.plm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.Project;

/**
 * @author Sunil
 *
 * ProjectDao.java Aug 9, 2020 5:31:53 PM
 */
@Repository
public interface ProjectDao extends JpaRepository<Project, String> {
	
	@Query("select p.projectName from Project p")
	public List<String> getProjectNameList();

}
