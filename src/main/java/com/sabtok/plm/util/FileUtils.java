/**
 * 
 */
package com.sabtok.plm.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.sabtok.plm.entity.AttachedFile;
import com.sabtok.plm.mongo.MangoDAO;

/**
 * @author Sunil
 *
 * FileUtils.java Aug 8, 2020 10:36:55 AM
 */
@Service
public class FileUtils {

	@Autowired
	private  MangoDAO mongoDao;
	
	public  String saveFile(byte[] bytedata,Map <String,String> fileData, String source) {
		//saveFileToMongo(bytedata,null);
		return "success";
	}
	
	private  String saveFileToMongo(byte[] bytedata,Map <String,String> fileData) {
		try {
			mongoDao.setDbName("test");
			mongoDao.setCollectionName("attachement");
			DB dataBase = mongoDao.getConnection().getDB("test");
			//byte[] bytedata = file.getBytes();
		    GridFS gridFs = new GridFS(dataBase);
			GridFSInputFile gridFSInputFile = gridFs.createFile(bytedata);
			gridFSInputFile.setFilename(fileData.get("fileName"));
			gridFSInputFile.setContentType(fileData.get("ContentType"));
			gridFSInputFile.save();
			return	"Success";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public  String saveFileToMongo(byte[] bytedata,AttachedFile.FileData fileData) {
		try {
			mongoDao.setDbName("test");
			mongoDao.setCollectionName("attachement");
			DB dataBase = mongoDao.getConnection().getDB("test");
			//byte[] bytedata = file.getBytes();
		    GridFS gridFs = new GridFS(dataBase);
			GridFSInputFile filea = gridFs.createFile(bytedata);
			filea.setFilename(fileData.getFileName());
			filea.setContentType(fileData.getContenetTye());
			filea.save();
			return	"Success";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public GridFSDBFile getGridFsAttachement(String fileName) throws IOException {
		mongoDao.setDbName("test");
		mongoDao.setCollectionName("attachement");
		DB dataBase = mongoDao.getConnection().getDB("test");
		  GridFS gridFs = new GridFS(dataBase);
		  GridFSDBFile  file = gridFs.findOne(fileName);
		  return file;
	}
}
