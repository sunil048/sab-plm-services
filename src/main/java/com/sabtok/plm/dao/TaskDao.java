/**
 * 
 */
package com.sabtok.plm.dao;

import java.util.List;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sabtok.plm.entity.Task;



/**
 * @author Sunil
 *
 * TaskDao.java Aug 2, 2020 10:40:44 AM
 */
public interface TaskDao extends JpaRepository<Task, String> {
	//public List <Task> getAllTasks();
	
	@Transactional
	@Modifying
	@Query("update Task set closedDate = ?1, status='Closed' where taskid = ?2")
	public int closeTask(String closedDate, String taskid);
	
	@Transactional
	@Modifying
	@Query("update Task set status = ?1 where taskid = ?2")
	public int changeTaskStatus(String status, String taskid);
	
	@Transactional
	@Modifying
	@Query("update Task set priority = ?1 where taskid = ?2")
	public int changeTaskPriority(String priority, String taskid);
	
	/*@Transactional
	@Modifying
	@NamedNativeQuery("Select task_var from plm_var")
	public List<String> getAllDefinedTaskStatus();*/
	
	//Added custom method this is not default method
	List<Task> getListByStatus(String status);
	
	List<Task> getListByProjectName(String projectName);
	
	@Query("select count(*) from Task where status='Open' OR status='open'")
	public Integer getOpenTaskCount();
	
	@Query("select count(*) from Task where status='Closed' OR status='closed'")
	public Integer getCloedTaskCount();
	
	@Query("select count(*) from Task where status='In progress'")
	public Integer getInprogressTaskCount();
	
	@Query("select count(*) from Task where status='Hold'")
	public Integer getHoldTaskCount();
	
	@Query("select count(*) from Task where status IS NULL OR status='' ")
	public Integer getNoStatusTaskCount();
}
