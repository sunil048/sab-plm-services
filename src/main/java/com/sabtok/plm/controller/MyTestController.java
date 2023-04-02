package com.sabtok.plm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@GetMapping("/list/{studentname}")
	public List<MyTest> getMyTestList(@PathVariable String studentname){
		System.out.println("Recived student name" + studentname);
		List<MyTest> stlist = myTestDao.findAllByStudent(studentname);
		return stlist;
	}
	
	@GetMapping("/test")
	public String test() {
		return "Success";
	}
	
	@GetMapping("/dashboard/{studentNameValue}")
	public Object getMyTestDashBoardDetails(@PathVariable String studentNameValue) {
		Map<String,Object> testDetails = new HashMap<String,Object>();
		List<MyTest> list = new ArrayList();
		List<MyTest> passList = new ArrayList();
		List<MyTest> failList = new ArrayList();
		
		List<MyTest> totalList = myTestDao.findAll();
		Map <String, Object> studentList =  new HashMap<String,Object>();
		for (MyTest test : totalList) {
			String studentName = test.getStudent();
			Integer NoOfAttemptes = test.getNumOfAttemptes();
			if (studentName.equalsIgnoreCase(studentNameValue)) {
				if(test.getResulte())
					passList.add(test);
				else
					failList.add(test);
			}
			
		}
		studentList.put("STUDENT_NAME", studentNameValue);
		studentList.put("TOTAL_TEST_NUMBERS", passList.size()+failList.size());
		studentList.put("PASSAD_NUMBERS", passList.size());
		studentList.put("FAILED_NUMBERS",failList.size());
		return studentList;
		
	}
	
	@GetMapping("/dashboard")
	public Object getMyTestDashBoardDetails1() {
		List<String> studentNames = myTestDao.getStudentNamesList();
		Map<String,Object> testDetails = new HashMap<String,Object>();
		List <Object> testDetails1 = new ArrayList<>();
		for (String studentName : studentNames) {
			Map<String,Object> testDetailsTemp = (Map<String, Object>) getMyTestDashBoardDetails(studentName);
			testDetails1.add(testDetailsTemp);
		}
		return testDetails1;
	}
}
