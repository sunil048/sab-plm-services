/**
 * 
 */
package com.sabtok.plm.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.sabtok.plm.entity.AttachedFile;
import com.sabtok.plm.service.AttachedFileService;
import com.sabtok.plm.util.FileUtils;

/**
 * @author Sunil
 *
 * AttachController.java Aug 5, 2020 4:19:04 PM
 */
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/attachement")
public class AttachController {

	@Autowired
	AttachedFileService fileService;
	
	@Autowired
	FileUtils fileUtils;

	@GetMapping("/download/{docId}")
	public void getAttachment(@PathVariable Integer docId,HttpServletResponse response) throws SQLException {
	
		 AttachedFile file = fileService.downLoadAttachement(docId).get();
	        try {
	            if (file.getDocument()!=null) {
	                response.setHeader("Content-Disposition", "inline;filename=\"" + file.getDocumentName() + "\"");
	                OutputStream out = response.getOutputStream();
	               /* response.setContentType("image/gif");*/
	                IOUtils.copy(file.getDocument().getBinaryStream(), out);
	                
	                out.flush();
	                out.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	}
	
	@GetMapping("/document")
	public void readAttachement(@RequestParam("docName") String fileName,HttpServletResponse response) throws IOException {
		  GridFSDBFile file = fileUtils.getGridFsAttachement(fileName);
		  if (file != null)
		  {
			  response.setHeader("Content-Disposition", "inline;filename=\"" + file.getFilename() + "\"");
	          OutputStream out = response.getOutputStream();
	          response.setContentType(file.getContentType());
	          file.writeTo(out);
	         // IOUtils.copy(fs.get("md5"), out);
	          out.flush();
	          out.close();
		  } else {
	          OutputStream out = response.getOutputStream();
	          String error = "File not found !";
	          out.write(error.getBytes());
	         // IOUtils.copy(fs.get("md5"), out);
	          out.flush();
	          out.close();
		  }
	}
	
	@GetMapping("/download")
	public void downloadAttachement(@RequestParam("docName") String fileName,HttpServletResponse response) throws IOException {
		  GridFSDBFile file = fileUtils.getGridFsAttachement(fileName);
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
