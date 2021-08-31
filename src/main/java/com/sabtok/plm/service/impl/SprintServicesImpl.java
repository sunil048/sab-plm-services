package com.sabtok.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sabtok.plm.dao.SprintDao;
import com.sabtok.plm.entity.Sprint;
import com.sabtok.plm.service.SprintServices;

@Component
public class SprintServicesImpl implements SprintServices {

	@Autowired
	SprintDao sprintdao;
	
	@Override
	public Sprint saveSprint(Sprint sprint) {
		return sprintdao.save(sprint);
	}

	@Override
	public List<Sprint> getAllSprint() {
		return sprintdao.findAll();
	}

	@Override
	public Sprint getSprintDetails(String sprintId) {
		return sprintdao.findById(sprintId).get();
	}

	@Override
	public Sprint updateSprint(Sprint sprint) {
		// TODO Auto-generated method stub
		return sprintdao.saveAndFlush(sprint);
	}

}
