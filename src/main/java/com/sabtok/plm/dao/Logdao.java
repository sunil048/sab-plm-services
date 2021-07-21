/**
 * 
 */
package com.sabtok.plm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sabtok.plm.entity.Log;

/**
 * @author Sunil
 *
 * Logdao.java Aug 11, 2020 3:53:01 PM
 */
@Repository
public interface Logdao extends JpaRepository<Log, Long>{

	@Query("select Count(*) from Log")
	public Long nextLogRowno();
	
	
	@Query("select l from Log l where  l.project= :project")
	public List<Log> getLogListByProject(@Param("project") String project);
	
	public List<Log> getLogListByProjectIn(List<String> projects);
	
	@Query(value = "SELECT SUM(efforts) FROM Logs where project=:taskID", nativeQuery = true)
	public Long getTotalEffortForTaskID(@Param("taskID") String taskID);
	
	@Query(value = "SELECT SUM(efforts) FROM LOGS", nativeQuery = true)
	public Long getTotalEffort();
	
	
	
}
