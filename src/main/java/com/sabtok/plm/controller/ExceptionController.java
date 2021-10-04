/**
 * 
 */
package com.sabtok.plm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.sabtok.plm.AppConstants;
import com.sabtok.plm.entity.AttachedFile;
import com.sabtok.plm.entity.AttachedFile.FileData;
import com.sabtok.plm.entity.Issue;
import com.sabtok.plm.mongo.MangoDAO;
import com.sabtok.plm.service.AttachedFileService;
import com.sabtok.plm.service.IssueService;
import com.sabtok.plm.util.DateUtils;
import com.sabtok.plm.util.FileUtils;
import com.sabtok.plm.util.IDGenerator;
import com.sabtok.plm.util.JsonUtil;
import com.sabtok.plm.util.RestCalls;

import javassist.bytecode.analysis.MultiArrayType;

/**
 * @author Sunil
 *
 * ExceptionController.java Aug 5, 2020 7:30:23 PM
 */
//@CrossOrigin("http://localhost:5000")
@RestController
@RequestMapping("issue")
public class ExceptionController {
	
	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@Autowired
	MangoDAO<Document> mongoDao;
	
	@Autowired
	FileUtils fileServices;
	
	@Autowired
	IssueService issueService;
	
	@Autowired
	AttachedFileService fileServ;
	
	@Value("${sabtok.issuidprefix}")
	private String issuidprefix;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/save")
	public ResponseEntity<String> saveException(@RequestParam("BODY") String issuePayload,@RequestParam(value="DOCUMENT",required=false) MultipartFile attachedFile
			) throws ParseException, IOException {
		try {
		    Issue issue = (Issue) JsonUtil.converStringToObject(issuePayload, Issue.class);
		    String issueID = issuidprefix+IDGenerator.getIssueId();
			issue.setIssueID(issueID);
		    if (attachedFile != null) {
		    	//String fileName = issueID+"_"+attachedFile.getOriginalFilename() ;
		    	byte[] bytedata = attachedFile.getBytes();
		    	AttachedFile file = new AttachedFile();
				file.setDocumentNo(IDGenerator.getDocumentId());
				file.setParentId(issue.getIssueID());
				file.setDocumentName(attachedFile.getOriginalFilename());
				file.setFileType(attachedFile.getContentType());
				file.setUploadedTime(DateUtils.getDateString());
				Blob myBlob = new SerialBlob(bytedata);
				file.setDocument(myBlob);;
				file = fileServ.saveAttachement(file);
				issue.setFileName(issue.getIssueID()+"_"+attachedFile.getOriginalFilename());//Need to display file name in issue form
		    }
		    String issueId = issueService.saveIssue(issue);
			//return new ResponseEntity <>(HttpStatus.OK).ok("Issue Created successfully ID ="+issueId);
			return new ResponseEntity <>(HttpStatus.OK).ok(issueId);
			//return "Issue Created successfully ID ="+issueID;
		}catch (Exception e) {
			e.printStackTrace();
			return (ResponseEntity<String>) new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED).notFound();
			//return "error";
		}
	}
	
	@GetMapping("/list")
	public Object getIssueList() {
		return issueService.getIssueList();
	}
	
	@GetMapping("/list-project/{projectName}")
	public Object getIssueListForProject(@PathVariable("projectName") String projectName) {
		return issueService.getIssueListForProject(projectName);
	}
	
	@GetMapping("/getIssue/{rowNo}")
	public Object getIssue(@PathVariable String rowNo) {
		return issueService.getIssue(Integer.valueOf(rowNo)).get();
	}
	
	@PostMapping("/updateaction")
	public boolean updateIssueAction(@RequestBody Map <String,String> updateData) {
		issueService.updateIssueActionTaken(updateData.get("ISSUEID"), updateData.get("ACTIONTAKEN_DATA"));
		return true;
	}
	
	@PostMapping("/close")
	public boolean closeIssue(@RequestParam("issueID") String issueID) {
		String closedDate = DateUtils.getDateString();
		issueService.closeIssue(issueID,closedDate);
		return true;
	}
	
	@GetMapping("/resttest")
	@ResponseBody
	public String restTest() {
		RestCalls rc = new RestCalls("Admin@123","Admin@123");
		String data1 = rc.getData(AppConstants.USERMANAGEMENT_URL);
		System.out.println(data1);
		return data1;
	}
	@GetMapping("/restlogin")
	public String restTest1() {
		RestCalls rc = new RestCalls("admin","admin");
		String data1 = rc.getData(AppConstants.USERMANAGEMENT_URL);
		System.out.println(data1);
		return data1;
	}
	
	//Add+1 client side to add next entry
	@GetMapping("/rownumber")
	public String getRowNumber() {
		return String.valueOf(issueService.getRowNumber());
	}
	
	@GetMapping("/dashboard")
	public Object getIssueDashBoardDetails() {
		Map <String,Integer> dashBoardDetails = new HashMap<String,Integer>();
		dashBoardDetails.put("TOTLA_ISSUES", issueService.getRowNumber());
		dashBoardDetails.put("OPEN_ISSUES", issueService.getOpenIssuesCount());
		dashBoardDetails.put("CLOSED_ISSUES", issueService.getClosedIssuesCount());
		return dashBoardDetails;
	}
	
}

