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
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
import com.sabtok.plm.entity.Issue;
import com.sabtok.plm.mongo.MangoDAO;

import javassist.bytecode.analysis.MultiArrayType;

/**
 * @author Sunil
 *
 * ExceptionController.java Aug 5, 2020 7:30:23 PM
 */
@RestController
@RequestMapping("issue")
public class ExceptionController {
	
	@Autowired
	MangoDAO<Document> mongoDao;
	
	@PostMapping("/save1")
	public String saveException_old(@RequestParam("docId") Long docId,@RequestParam("document") MultipartFile attachedFile,
			@RequestParam("CreatedDate") String createdDate) throws ParseException, IOException {
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date date = formate.parse(createdDate);
		byte[] bytedata = attachedFile.getBytes();
		System.out.println(docId);
		System.out.println(attachedFile);
		System.out.println(date.getDate());
		MongoClient mongoClient = new MongoClient("192.168.92.137", 27017);
		DB database = mongoClient.getDB("test");
		BasicDBObjectBuilder doc = BasicDBObjectBuilder.start();
		
		doc.append("DOC_ID", docId);
		doc.append("CREATED_DATE", date);
		doc.append("DOCUMENT", bytedata);
		
		database.getCollection("attachement").save(doc.get());
		return "success";
		
	}
	
	@PostMapping("/save2")
	public String saveException2(@RequestBody Map<String,Object> requestBody) throws ParseException, IOException {
		SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Date date = formate.parse((String) requestBody.get("CREATEDDATE"));
		Object attachedFile = requestBody.get("DOCUMENT");
		String docId = (String) requestBody.get("DOCID");
		String fileName = (String) requestBody.get("FILENAME");;
		//byte[] bytedata = attachedFile.getBytes();
		System.out.println(docId);
		System.out.println(attachedFile);
		System.out.println(date.getDate());
		MongoClient mongoClient = new MongoClient("192.168.92.137", 27017);
		DB database = mongoClient.getDB("test");
		BasicDBObjectBuilder doc = BasicDBObjectBuilder.start();
		
		doc.append("DOC_ID", docId);
		doc.append("CREATED_DATE", date);
		doc.append("DOCUMENT", attachedFile);
		doc.append("fileName", fileName);
		
		database.getCollection("attachement").save(doc.get());
		
		return "success";
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveException3(@RequestParam("DOCID") Long docId,@RequestParam("DOCUMENT") MultipartFile attachedFile,
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
			Document doc = new Document();
			doc.append("DOC_ID", docId);
			doc.append("CREATED_DATE", date);
			doc.append("DOCUMENT", filea);
			String status = mongoDao.insertOne(doc);
			return	new ResponseEntity<>(HttpStatus.OK).ok(status);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.OK).ok(e.getMessage());
		}
	}
	
	@GetMapping("/getIssue")
	public Object getIssue() {
		mongoDao.setDbName("test");
		mongoDao.setCollectionName("attachement");
		BasicDBObject filter = new BasicDBObject();
		filter.append("DOC_ID", 1234567);
		List <Document> data = mongoDao.findByQuery(filter);
		System.out.println(data);
		return data;
	}
	
	@GetMapping("/document")
	public void getAttachement(@RequestParam("docName") String fileName,HttpServletResponse response) throws IOException {
		mongoDao.setDbName("test");
		mongoDao.setCollectionName("attachement");
		DB dataBase = mongoDao.getConnection().getDB("test");
		  GridFS gridFs = new GridFS(dataBase);
		  GridFSDBFile  file = gridFs.findOne(fileName);
		  response.setHeader("Content-Disposition", "inline;filename=\"" + file.getFilename() + "\"");
          OutputStream out = response.getOutputStream();
          response.setContentType(file.getContentType());
          file.writeTo(out);
         // IOUtils.copy(fs.get("md5"), out);
          out.flush();
          out.close();
	}
	
	@GetMapping("/download")
	public void downloadAttachement(@RequestParam("docName") String fileName,HttpServletResponse response) throws IOException {
		mongoDao.setDbName("test");
		mongoDao.setCollectionName("attachement");
		DB dataBase = mongoDao.getConnection().getDB("test");
		  GridFS gridFs = new GridFS(dataBase);
		  GridFSDBFile  file = gridFs.findOne(fileName);
		  response.setHeader("Content-Disposition", "inline;filename=\"" + file.getFilename() + "\"");
          String mimeType = file.getContentType();
          response.setContentType(mimeType != null? mimeType:"application/octet-stream");
          response.setContentLength((int) file.getLength());
          response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getFilename() + "\"");
          ServletOutputStream os  = response.getOutputStream();
          byte[] bufferData = new byte[1024];
          InputStream fis = file.getInputStream();
          int read=0;
          while((read = fis.read(bufferData))!= -1){
              os.write(bufferData, 0, read);
          }
          os.flush();
          os.close();
          fis.close();
          System.out.println("File downloaded at client successfully");
	}
	

}
