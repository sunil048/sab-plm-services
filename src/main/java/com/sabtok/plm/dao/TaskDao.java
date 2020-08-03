/**
 * 
 */
package com.sabtok.plm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sabtok.plm.entity.Task;



/**
 * @author Sunil
 *
 * TaskDao.java Aug 2, 2020 10:40:44 AM
 */
public interface TaskDao extends JpaRepository<Task, String> {
	//public List <Task> getAllTasks();
}
