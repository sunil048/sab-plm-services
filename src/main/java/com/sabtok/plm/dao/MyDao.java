/**
 * 
 */
package com.sabtok.plm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.util.DriverDataSource;

/**
 * @author Sunil
 *
 * MyDao.java Apr 5, 2021 11:26:24 PM
 */
@Component
public class MyDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*@Autowired
	private  DriverManagerDataSource dataSourec;*/
	
	@Autowired
	private EntityManager em;
	
	private  List<String> taskStatus = new Vector<String>();
	private  List<String> taskPriorityList = new Vector<String>();
	private  List<String> projectNameList = new Vector<String>();
	private  List<String> taskTypes = new Vector<String>();
	
	public  List<String> getTaskStatus() throws SQLException{
		/*if (taskStatus.isEmpty()) {
			//jdbcTemplate.query("select task_var from plm_var",new String());
			Connection con = dataSourec.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select task_var from plm_var");
			while(rs.next()) {
				taskStatus.add(rs.getString(0));
			}
		}*/
		if (taskStatus.isEmpty()) {
			Query q = em.createNativeQuery("select task_var from plm_var");
			List data =  q.getResultList();
			for (Object obj : data) {
				taskStatus.add(String.valueOf(obj));
			}
		}
		return taskStatus;
	}
	
	public  List<String> getTaskPriorityList() throws SQLException{
		/*if (taskStatus.isEmpty()) {
			//jdbcTemplate.query("select task_var from plm_var",new String());
			Connection con = dataSourec.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select task_var from plm_var");
			while(rs.next()) {
				taskStatus.add(rs.getString(0));
			}
		}*/
		if (taskPriorityList.isEmpty()) {
			Query q = em.createNativeQuery("select task_priority_var from plm_var");
			List data =  q.getResultList();
			for (Object obj : data) {
				taskPriorityList.add(String.valueOf(obj));
			}
		}
		
		return taskPriorityList;
	}
	
	public  List<String> getProjectNameList() throws SQLException{
		if (projectNameList.isEmpty()) {
			Query q = em.createNativeQuery("select project_names from plm_var");
			List<String> data =  q.getResultList();
			for (Object obj : data) {
				projectNameList.add(String.valueOf(obj));
			}
		}
		
		return projectNameList;
	}
	
	public  List<String> getTaskTypes() throws SQLException{
		if (taskTypes.isEmpty()) {
			Query q = em.createNativeQuery("select TASK_TYPE from plm_var");
			List<String> data =  q.getResultList();
			for (Object obj : data) {
				taskTypes.add(String.valueOf(obj));
			}
		}
		
		return taskTypes;
	}
}
