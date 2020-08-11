/**
 * 
 */
package com.sabtok.plm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.Skill;

/**
 * @author Sunil
 *
 * SkillDao.java Aug 9, 2020 6:42:22 PM
 */
@Repository
public interface SkillDao extends JpaRepository<Skill, String> {

	@Query("select s.name from Skill s")
	public List<String> findById();
}
