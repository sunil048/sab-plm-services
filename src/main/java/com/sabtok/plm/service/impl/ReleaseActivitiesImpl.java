package com.sabtok.plm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sabtok.plm.dao.ReleaseDao;
import com.sabtok.plm.entity.Release;
import com.sabtok.plm.service.ReleaseActivities;
import com.sabtok.plm.util.IDGenerator;

@Component
public class ReleaseActivitiesImpl implements ReleaseActivities{

	@Autowired
	ReleaseDao releaseDao;
	
	@Override
	public List<Release> getAllReleases() {
		return releaseDao.findAll();
	}

	@Override
	public String createReleaseActivity(Release rel) {
		releaseDao.save(rel);
		return "Added";
	}

	@Override
	public String getReleaseId() {
		return "REL"+IDGenerator.getReleaseId();
	}

	@Override
	public List<Release> getAllReleasesForProject(String projectName) {
		// TODO Auto-generated method stub
		return releaseDao.findAllByProject(projectName);
	}

}
