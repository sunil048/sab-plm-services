package com.sabtok.plm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.Release;

@Repository
public interface ReleaseDao extends JpaRepository<Release, String> {

	public List<Release> findAllByProject(String projectName);
}
