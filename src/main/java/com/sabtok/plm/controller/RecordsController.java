/**
 * 
 */
package com.sabtok.plm.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.engine.jdbc.internal.BinaryStreamImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sabtok.plm.dao.RecordDao;
import com.sabtok.plm.entity.Records;
import com.sabtok.plm.util.IDGenerator;

/**
 * @author Sunil
 *
 * RecordsController.java Jun 17, 2021 9:09:45 PM
 */

@RestController()
@RequestMapping("/records")
public class RecordsController {

	@Autowired
	RecordDao recDao;
	
	@PostMapping("/upload")
	public void uploadRecord(@RequestParam(value="DOCUMENT",required=false) MultipartFile uploadedFile ,
			@RequestParam("BODY") String issuePayload) throws IOException, SerialException, SQLException {
		Records recod = new Records();
		recod.setRecordId(IDGenerator.getLongId());
		recod.setRecordName(uploadedFile.getOriginalFilename());
		recod.setRecordType(uploadedFile.getContentType());
		byte[] fileContentByte = uploadedFile.getBytes();
		Blob myBlob = new SerialBlob(fileContentByte);
		//System.out.println("fileContentByte "+Arrays.toString(fileContentByte));
	//	recod.setRecordStremData(new ByteArrayInputStream(uploadedFile.getBytes()));
	//	recod.setRecordContenet(uploadedFile.getBytes());
		//recod.setFilebinaryData(Arrays.toString(fileContentByte));
		//recod.setRecordContenet(fileContentByte);
		recod.setRecordBlobContent(myBlob);
		recDao.save(recod);
	}
	
	@GetMapping("/download/{RecodId}")
	public void downloadRecord(@PathVariable("RecodId") Long recodId,HttpServletResponse response) throws IOException, SQLException {
		Records record = recDao.findById(recodId).get();
		 response.setHeader("Content-Disposition", "inline;filename=\"" +record.getRecordName()+ "\"");
         OutputStream out = response.getOutputStream();
        /* response.setContentType("image/gif");
         response.setContentType("image/jpg");
         response.setContentType("text/html");*/
      //   InputStream myInputStream = new ByteArrayInputStream(record.getRecordContenet()); 
		/*
		 * InputStream sts = record.getRecordBlobContent().getBinaryStream();
		 * StringBuilder sb = new StringBuilder(); while ((sts.read()) != -1) { if
		 * (sts.read() != -1) sb.append(sts.read()); }
		 */
         
         InputStream is = record.getRecordBlobContent().getBinaryStream();
       //  InputStream ss = new ByteArrayInputStream(record.getFilebinaryData().getBytes());
       //  InputStream is = record.getRecordStremData();
         IOUtils.copy(is, out);
         out.flush();
         out.close();
         
         
      /*   try (BufferedInputStream bis = new BufferedInputStream(myInputStream);
                 FileOutputStream fos = new FileOutputStream("HelloFile")) {
  
             byte[] data = new byte[1024];
             int count;
             while ((count = bis.read(data, 0, 1024)) != -1) {
                 fos.write(data, 0, count);
             }
         }*/
      /* BufferedInputStream bis = new BufferedInputStream(myInputStream);
        		 ServletOutputStream fos       = response.getOutputStream();
  
             byte[] data = new byte[1024];
             int count;
             while ((count = bis.read(data, 0, 1024)) != -1) {
                 fos.write(data, 0, count);
             }
             fos.flush();
             fos.close();
             bis.close();*/
         
	}
	
	@GetMapping("/list")
	public List<Records> getFileList(){
		return recDao.findAll();
	}
	
	
}
