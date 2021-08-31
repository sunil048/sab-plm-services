/**
 * 
 */
package com.sabtok.plm.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sabtok.plm.entity.AttachedFile;
import com.sabtok.plm.entity.Log;
import com.sabtok.plm.entity.AttachedFile.FileData;
import com.sabtok.plm.entity.Comment;
import com.sabtok.plm.service.AttachedFileService;
import com.sabtok.plm.service.CommentService;
import com.sabtok.plm.service.LogService;
import com.sabtok.plm.util.DateUtils;
import com.sabtok.plm.util.FileUtils;
import com.sabtok.plm.util.IDGenerator;

/**
 * @author Sunil
 *
 * LogController.java Aug 11, 2020 3:47:53 PM
 */


@RestController
@RequestMapping("/log")
public class LogController {

	@Autowired
	private LogService logService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private FileUtils fileServices;
	
	@Autowired
	private AttachedFileService attachFileService;
	
	@GetMapping("/list")
	public List<Log> getLogList(){
		return logService.getLogList();
	}
	@GetMapping("/projectlogs/{projectId}")
	public List<Log> getLogListByProject(@PathVariable("projectId") String project){
		return logService.getLogListByProject(project);
	}
	
	@GetMapping("/comments/{projectId}")
	public List<Comment> getComments(@PathVariable("projectId") String project){
		return commentService.getComment(project);
	}
	
	@PostMapping("/save")
	public Log saveLog(
			@RequestParam("SLNO") Long slNo,
			@RequestParam("PROJECT") String project,
			@RequestParam("DETAIL") String details,
			@RequestParam("SUBTASK") String subtask,
			@RequestParam("SKILL") String skill,
			@RequestParam("EFFORT") String effort,
			@RequestParam(value="ATTACHEDFILE",required=false) MultipartFile attachedFile) throws IOException, SerialException, SQLException {
		Log log = new Log();
		log.setRowNo(slNo);
		log.setProject(project);
		log.setDetails(details);
		log.setId(IDGenerator.getUUID().toString());
		log.setSubtask(subtask);
		log.setSkill(skill);
		if (effort == null || effort.isEmpty())//prod bug fix effort.isBlank() is in 11 but prod is 1.8
			effort = "0";
		log.setEfforts(Integer.valueOf(effort));
		//since log is creating first need file name if attached file found in request
		 if (attachedFile != null) {
			 log.setFileName(attachedFile.getOriginalFilename());
		 }
		log.setDate(DateUtils.getDateString());
		log = logService.saveLog(log);
		 if (attachedFile != null) {
		    	byte[] bytedata = attachedFile.getBytes();
				AttachedFile file = new AttachedFile();
				file.setDocumentNo(IDGenerator.getDocumentId());
				file.setParentId(log.getProject());
				file.setDocumentName(attachedFile.getOriginalFilename());
				file.setFileType(attachedFile.getContentType());
				file.setUploadedTime(DateUtils.getDateString());
				Blob myBlob = new SerialBlob(bytedata);
				file.setDocument(myBlob);;
				attachFileService.saveAttachement(file);
		    }
		return log;
	}
	
	@PostMapping("/save-comment1")
	public Log saveIssueCommentsInLog1(
			@RequestParam("PROJECT") String project,
			@RequestParam("DETAIL") String details,
			@RequestParam(value = "SUBTASK", required = false) String subtask,
			@RequestParam(value="SKILL",required = false) String skill,
			@RequestParam("EFFORT") String effort,
			@RequestParam(value="ATTACHEDFILE",required=false) MultipartFile attachedFile) throws IOException, SerialException, SQLException {
		Log log = new Log();
		log.setRowNo(logService.nextLogRowno());
		log.setProject(project);
		log.setDetails(details);
		log.setId(IDGenerator.getUUID().toString());
		
		if (effort == null || effort.isEmpty())//prod bug fix effort.isBlank() is in 11 but prod is 1.8
			effort = "0";
		log.setEfforts(Integer.valueOf(effort));
		//since log is creating first need file name if attached file found in request
		 if (attachedFile != null) {
			 log.setFileName(attachedFile.getOriginalFilename());
		 }
		log.setDate(DateUtils.getDateString());
		log = logService.saveLog(log);
		 if (attachedFile != null) {
		    	byte[] bytedata = attachedFile.getBytes();
				AttachedFile file = new AttachedFile();
				file.setDocumentNo(IDGenerator.getDocumentId());
				file.setParentId(log.getProject());
				file.setDocumentName(attachedFile.getOriginalFilename());
				file.setFileType(attachedFile.getContentType());
				file.setUploadedTime(DateUtils.getDateString());
				Blob myBlob = new SerialBlob(bytedata);
				file.setDocument(myBlob);;
				attachFileService.saveAttachement(file);
		    }
		return log;
	}
	
	@PostMapping("/save-comment")
	public Comment saveIssueCommentsInLog(
			@RequestParam("PROJECT") String project,
			@RequestParam("DETAIL") String details,
			@RequestParam(value = "SUBTASK", required = false) String subtask,
			@RequestParam(value="SKILL",required = false) String skill,
			@RequestParam("EFFORT") String effort,
			@RequestParam(value="ATTACHEDFILE",required=false) MultipartFile attachedFile) throws IOException, SerialException, SQLException {
		Comment cm = new Comment();
		cm.setId(IDGenerator.getCommentId());
		cm.setProject(project);
		cm.setDetails(details);
		
		Log log = new Log();
	//	log.setProject(project);
	//	log.setDetails(details);
	//	log.setId(IDGenerator.getUUID().toString());
		
		if (effort == null || effort.isEmpty())//prod bug fix effort.isBlank() is in 11 but prod is 1.8
			effort = "0";
		//log.setEfforts(Integer.valueOf(effort));
		cm.setEffort(Integer.valueOf(effort));
		//since log is creating first need file name if attached file found in request
		 if (attachedFile != null) {
			// log.setFileName(attachedFile.getOriginalFilename());
			 cm.setFileName(attachedFile.getOriginalFilename());
		 }
		//log.setDate(DateUtils.getDateString());
		cm.setDate(DateUtils.getDateString());
		//log = logService.saveLog(log);
		cm = commentService.saveComment(cm);
		 if (attachedFile != null) {
		    	byte[] bytedata = attachedFile.getBytes();
				AttachedFile file = new AttachedFile();
				file.setDocumentNo(IDGenerator.getDocumentId());
				file.setParentId(cm.getProject());
				file.setDocumentName(attachedFile.getOriginalFilename());
				file.setFileType(attachedFile.getContentType());
				file.setUploadedTime(DateUtils.getDateString());
				Blob myBlob = new SerialBlob(bytedata);
				file.setDocument(myBlob);;
				attachFileService.saveAttachement(file);
		    }
		return cm;
	}
	
	@GetMapping("/nextlogRowNumber")
	public String getNextLogNumber() {
		return String.valueOf(logService.nextLogRowno());
	}
	
	@GetMapping("/logdetails/{rowno}")
	public Log getLog(@PathVariable("rowno") Long rowNo) {
		return logService.getLogDetails(rowNo).get();
	}
	
	@GetMapping("/totaleffort/{taskID}")
	public String getTotalEffortForTask(@PathVariable("taskID") String taskID) {
		return String.valueOf(logService.getTotalEffortForTask(taskID));
	}
	@GetMapping("/totaleffort")
	public String getTotalEffort() {
		return String.valueOf(logService.getTotalEffort());
	}
	
	@GetMapping("/dashboard")
	public Object dashBoardDeatials() {
		Map<String,Long> logDashBoardDetails = new HashMap();
		logDashBoardDetails.put("TOTAL_LOGS", logService.nextLogRowno());
		return logDashBoardDetails;
	}
}
