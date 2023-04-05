package com.sabtok.plm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.MyTest;

@Repository
public interface MyTestDao extends JpaRepository<MyTest, String> {

	public List<MyTest> findAllByStudentAndSkill(String student,String skill);
	public List<MyTest> findAllByStudent(String student);
	
	@Query("select distinct(student) from MyTest")
	public List<String> getStudentNamesList();
} 
