package com.sabtok.plm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.dao.MyTestDao;
import com.sabtok.plm.entity.MyTest;
import com.sabtok.plm.util.IDGenerator;

@RestController
@RequestMapping("/MyTest")
public class MyTestController {
	
	private double percentageThreshold = 70;
	
	@Autowired
    private MyTestDao myTestDao;

	
	@PostMapping("/save")
	public MyTest saveMyTest(@RequestBody MyTest mytest) {
		System.out.println(mytest);
		double perc =  ( (double) mytest.getMarksScored()/mytest.getTotalMarkes())*100;
		mytest.setPercentage(perc);
		if (perc > percentageThreshold) {
			mytest.setResulte(true);
		} else {
			mytest.setResulte(false);
		}
		mytest.setNumOfAttemptes(getNoOfAttempts(mytest.getStudent(),mytest.getSkill())+1);
		mytest.setMeetingId("EVL"+IDGenerator.getTestId());//Evolution
		//this method saves and update
		myTestDao.save(mytest);
		System.out.println(perc);
		return mytest;
	}
	
	@GetMapping("/Delete/{meeting_id}")
	public String deletTestRecords(@PathVariable("meeting_id") String meetingid) {
		System.out.println(meetingid);
		myTestDao.deleteById(meetingid);
	
     return "Deleted seccessfully";
		
	}
	
	@GetMapping("/details/{testId}")
	public MyTest getTestDetails(@PathVariable("testId") String testId) {
		
		MyTest mt = myTestDao.findById(testId).get();
		return mt;
	}
	
	private Integer getNoOfAttempts (String sname, String skil) {
		List<MyTest> myTestList = myTestDao.findAllByStudentAndSkill(sname, skil);
	return myTestList.size();
	}
	@GetMapping("/list/{student}/{skill}")
	public List<MyTest> getMyTestArrayList(@PathVariable("student") String student, @PathVariable("skill") String skill){
		return myTestDao.findAllByStudentAndSkill(student,skill);
	}
	
	@GetMapping("/list")
	public List<MyTest> getMyTestArrayList1(){
		return myTestDao.findAll();
	}
	
}
