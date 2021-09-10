package com.sabtok.plm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sabtok.plm.entity.Sprint;

@Service
public interface SprintServices {

	public Sprint saveSprint(Sprint sprint);
	public List<Sprint> getAllSprint();
	public Sprint getSprintDetails(String sprintId);
	public Sprint updateSprint(Sprint sprint);
}
