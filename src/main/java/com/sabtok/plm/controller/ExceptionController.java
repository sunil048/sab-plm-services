/**
 * 
 */
package com.sabtok.plm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.Document;
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
import com.sabtok.plm.service.IssueService;
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
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("issue")
public class ExceptionController {
	
	@Autowired
	MangoDAO<Document> mongoDao;
	
	@Autowired
	FileUtils fileServices;
	
	@Autowired
	IssueService issueService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveException(@RequestParam("DOCUMENT") MultipartFile attachedFile,
			@RequestParam("BODY") String issuePayload) throws ParseException, IOException {
		try {
		    Issue issue = (Issue) JsonUtil.converStringToObject(issuePayload, Issue.class);
		    String issueId = issueService.saveIssue(issue);
		    byte[] bytedata = attachedFile.getBytes();
			AttachedFile.FileData fileData =  new AttachedFile().new FileData(issueId+"_"+attachedFile.getOriginalFilename(),attachedFile.getContentType());
			fileServices.saveFileToMongo(bytedata, fileData);
			return new ResponseEntity <>(HttpStatus.OK).ok("Issue Created successfully ID ="+issueId);
			//return "Issue Created successfully ID ="+issueID;
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED).ok(e.getMessage());
			//return "error";
		}
		
		
	}
	
	@GetMapping("/list")
	public Object getIssueList() {
		return issueService.getIssueList();
	}
	
	
	@GetMapping("/getIssue/{rowNo}")
	public Object getIssue(@PathVariable String rowNo) {
		return issueService.getIssue(Integer.valueOf(rowNo)).get();
	}
	
	@GetMapping("/getIssue")
	public Object getIssueMongo() {
		mongoDao.setDbName("test");
		mongoDao.setCollectionName("attachement");
		BasicDBObject filter = new BasicDBObject();
		RestCalls rc = new RestCalls("Admin@123","Admin@123");
		String data1 = rc.getData("http://localhost:8082/generateTaskId");
		System.out.println(data1);
		filter.append("DOC_ID", 1234567);
		List <Document> data = mongoDao.findByQuery(filter);
		System.out.println(data);
		return data;
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
	
	/*
	 * 
	 * @PostMapping("/save")
	public ResponseEntity<Object> saveFileAsGridFS(@RequestParam("DOCID") Long docId,@RequestParam("DOCUMENT") MultipartFile attachedFile,
			@RequestParam("CREATEDDATE") String createdDate,@RequestParam("FILENAME") String fileName) throws ParseException, IOException {
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date date = formate.parse(createdDate);
		byte[] bytedata = attachedFile.getBytes();
		
		try {
			mongoDao.setDbName("test");
			mongoDao.setCollectionName("attachement");
			DB dataBase = mongoDao.getConnection().getDB("test");
		    GridFS gridFs = new GridFS(dataBase);
			GridFSInputFile filea = gridFs.createFile(bytedata);
			filea.setFilename(fileName);
			filea.setContentType(attachedFile.getContentType());
			filea.save();
		//	Document doc = new Document();
		//	doc.append("DOC_ID", docId);
		//	doc.append("CREATED_DATE", date);
		//	doc.append("DOCUMENT", filea);
		//	String status = mongoDao.insertOne(doc);
			return	new ResponseEntity<>(HttpStatus.OK).ok("Success");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.OK).ok(e.getMessage());
		}
	}
	
	
		
	@PostMapping("/savenryhjy")
	public String saveException2(@RequestBody Map<String,Object> requestBody) throws ParseException, IOException {
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		//Date date = formate.parse((String) requestBody.get("CREATEDDATE"));
		Object attachedFile = requestBody.get("DOCUMENT");
		//byte[] bytedata = attachedFile.getBytes();
		System.out.println(attachedFile);
		MongoClient mongoClient = new MongoClient("192.168.92.137", 27017);
		DB database = mongoClient.getDB("test");
		BasicDBObjectBuilder doc = BasicDBObjectBuilder.start();
		
		database.getCollection("attachement").save(doc.get());
		
		return "success";
		
	}
	
	@PostMapping("/save22")
	public ResponseEntity<Object> saveFileAsGridFS(@RequestParam("DOCID") Long docId,@RequestParam("DOCUMENT") MultipartFile attachedFile,
			@RequestParam("CREATEDDATE") String createdDate,@RequestParam("FILENAME") String fileName) throws ParseException, IOException {
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date date = formate.parse(createdDate);
		byte[] bytedata = attachedFile.getBytes();
		Map <String,String> fileData = new HashMap<String,String>();
		fileData.put("", "");
		try {
			fileServices.saveFile(bytedata, fileData, "MONGO");
			return	new ResponseEntity<>(HttpStatus.OK).ok("Success");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.OK).ok(e.getMessage());
		}
	}
	
		@PostMapping("/save11111111111")
//	public String saveException_old(@RequestParam("DOCUMENT") MultipartFile attachedFile) throws ParseException, IOException {
	public String saveException_old(@RequestBody Issue issue) throws ParseException, IOException {
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		//Date date = formate.parse(createdDate);
		Issue is = issue;
	//	byte[] bytedata = attachedFile.getBytes();
	//	System.out.println(attachedFile);
		//System.out.println(date.getDate());
		MongoClient mongoClient = new MongoClient("192.168.92.137", 27017);
		DB database = mongoClient.getDB("test");
		BasicDBObjectBuilder doc = BasicDBObjectBuilder.start();
		//doc.append("CREATED_DATE", date);
	//	doc.append("DOCUMENT", bytedata);
		
	//	database.getCollection("attachement").save(doc.get());
		return "success";
		
	}
	 * 
	 * 
	 * 
	 */
	
}

