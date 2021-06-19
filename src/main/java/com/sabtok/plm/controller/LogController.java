/**
 * 
 */
package com.sabtok.plm.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sabtok.plm.service.AttachedFileService;
import com.sabtok.plm.service.LogService;
import com.sabtok.plm.util.DateUtils;
import com.sabtok.plm.util.FileUtils;
import com.sabtok.plm.util.IDGenerator;

/**
 * @author Sunil
 *
 * LogController.java Aug 11, 2020 3:47:53 PM
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/log")
public class LogController {

	@Autowired
	private LogService logService;
	
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
	
	@PostMapping("/save")
	public Log saveLog(
			@RequestParam("SLNO") Long slNo,
			@RequestParam("PROJECT") String project,
			@RequestParam("DETAIL") String details,
			@RequestParam(value="ATTACHEDFILE",required=false) MultipartFile attachedFile) throws IOException, SerialException, SQLException {
		Log log = new Log();
		log.setRowNo(slNo);
		log.setProject(project);
		log.setDetails(details);
		log.setId(IDGenerator.getUUID().toString());
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
	
	@GetMapping("/nextlogRowNumber")
	public String getNextLogNumber() {
		return String.valueOf(logService.nextLogRowno());
	}
	
	@GetMapping("/logdetails/{rowno}")
	public Log getLog(@PathVariable("rowno") Long rowNo) {
		return logService.getLogDetails(rowNo).get();
	}
}
