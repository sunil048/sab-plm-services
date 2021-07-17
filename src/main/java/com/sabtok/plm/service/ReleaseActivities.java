package com.sabtok.plm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sabtok.plm.entity.Release;

@Service
public interface ReleaseActivities {
	public String getReleaseId();
	public List<Release> getAllReleases();
	public List<Release> getAllReleasesForProject(String projectName);
	public String createReleaseActivity(Release rel);
}
