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
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.entity.AttachedFile;
import com.sabtok.plm.service.AttachedFileService;

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
}
