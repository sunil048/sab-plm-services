package com.sabtok.plm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabtok.plm.entity.MyTest;

@Repository
public interface MyTestDao extends JpaRepository<MyTest, String> {

	public List<MyTest> findAllByStudentAndSkill(String student,String skill);
}
