/**
 * 
 */
package com.sabtok.plm.controller;

import java.io.IOException;
import java.util.List;

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
import com.sabtok.plm.service.LogService;
import com.sabtok.plm.util.DateUtils;
import com.sabtok.plm.util.FileUtils;

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
			@RequestParam("SLNO") Integer slNo,
			@RequestParam("PROJECT") String project,
			@RequestParam("DETAIL") String details,
			@RequestParam(value="ATTACHEDFILE",required=false) MultipartFile attachedFile) throws IOException {
		Log log = new Log();
		log.setRowNo(slNo);
		log.setProject(project);
		log.setDetails(details);
		if(attachedFile != null) {
			String fileName ="Log_"+log.getRowNo()+"_"+attachedFile.getOriginalFilename() ;
			log.setFileName(fileName);
		}
			
		log.setDate(DateUtils.getDateString());
		log = logService.saveLog(log);
		 if (attachedFile != null) {
		    	byte[] bytedata = attachedFile.getBytes();
				AttachedFile.FileData fileData =  new AttachedFile().new FileData(log.getFileName(),attachedFile.getContentType());
				fileServices.saveFileToMongo(bytedata, fileData);
		    }
		return log;
	}
	
	@GetMapping("/nextlogRowNumber")
	public String getNextLogNumber() {
		return String.valueOf(logService.nextLogRowno());
	}
}
