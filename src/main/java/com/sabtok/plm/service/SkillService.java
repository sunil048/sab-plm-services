/**
 * 
 */
package com.sabtok.plm.service;

import java.util.List;

import com.sabtok.plm.entity.Skill;

/**
 * @author Sunil
 *
 * SkillService.java Aug 9, 2020 6:40:27 PM
 */

public interface SkillService {

	public List<String> getSkillNames();
	public List<Skill> getSkillList();
}
