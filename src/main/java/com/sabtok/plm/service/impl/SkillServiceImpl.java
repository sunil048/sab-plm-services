/**
 * 
 */
package com.sabtok.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabtok.plm.dao.SkillDao;
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
	/* (non-Javadoc)
	 * @see com.sabtok.plm.service.SkillService#getSkillNames()
	 */
	@Override
	public List<String> getSkillNames() {
		List <String> names = skillDao.findById();
		return names;
	}

}
