/**
 * 
 */
package com.sabtok.plm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabtok.plm.dao.SkillDao;
import com.sabtok.plm.entity.Skill;
import com.sabtok.plm.service.EffortService;
import com.sabtok.plm.service.SkillService;

/**
 * @author Sunil
 *
 * SkillServiceImpl.java Aug 9, 2020 6:41:04 PM
 */
@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDao skillDao;
	
	@Autowired
	EffortService effortSer;
	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.SkillService#getSkillNames()
	 */
	@Override
	public List<String> getSkillNames() {
		List <String> names = skillDao.findById();
		return names;
	}
	
	@Override
	public List<Skill> getSkillList() {
		List<Skill> l = skillDao.findAll();
		//l = l.stream().map(s -> s.setTotalEffort(4L)).collect(Collectors.toList());
		l = l.stream().map(s-> {
			s.setTotalEffort(effortSer.getTotalEffortForTask(s.getId()));
			return s;
		}).collect(Collectors.toList());
		
		return l;
	}

	
}
