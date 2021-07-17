package com.sabtok.plm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sabtok.plm.entity.Efforts;

public interface EffortsDao extends JpaRepository<Efforts, Long> {

	@Query("select count(*) from Efforts")
	public Long getNextEntry();
	
	@Query(value = "SELECT SUM(hours) FROM EFFORTS where task_id=:taskID", nativeQuery = true)
	public Long getTotalEffortForTaskID(@Param("taskID") String taskID);
}
