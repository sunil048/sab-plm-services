/**
 * 
 */
package com.sabtok.plm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.sabtok.plm.entity.SubTask;

/**
 * @author Sunil
 *
 * SubtaskDao.java Jun 16, 2021 3:22:29 PM
 */
@Component
public interface SubtaskDao extends JpaRepository<SubTask, String> {
	
	public List<SubTask> getSubTaskListByTaskid(String taskId);
	
	@Transactional
	@Modifying
	@Query("update SubTask set closeddate = ?1, status='Closed' where subTaskId = ?2")
	public int closeSubTask(String closedDate, String subtaskid);
}
