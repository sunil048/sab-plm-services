/**
 * 
 */
package com.sabtok.plm.controller;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.sabtok.plm.AppConstants;
import com.sabtok.plm.util.DateUtils;

/**
 * @author Sunil
 *
 * UtilController.java Aug 10, 2020 9:45:56 AM
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/util")
public class UtilController {

	@Autowired
	private DataSource dataSorces;

	@Autowired
	private Environment environment;
	
	@Autowired
	BuildProperties buildProperties;
	
	@Value("${database.monodburl}")
	private String mongodburl;
	
	@GetMapping("/getConnection")
	public String testConnection() {
		return "success";
	}
	
	@GetMapping("/getdate")
	public Object getDate() {
		Date date = DateUtils.getDate();
		return date;
	}
	
	@GetMapping("/getdatestring")
	public Object getDateString() {
		String date = DateUtils.getJav8Date();
		return date;
	}
	
	@GetMapping("/sysinfo")
	public Object getSystemProperties() {
		return System.getProperties();
	}
	
	@GetMapping("/appinfo")
	public Object getApplicationProperties() {
		Map<String,Object> appproperties = new LinkedHashMap();
		appproperties.put("APP_ENVIRONMENT", AppConstants.getApp_environment());
		appproperties.put("OS", System.getProperty("os.name"));
		appproperties.put("OS_VERSION", System.getProperty("os.version"));
		appproperties.put("java.runtime.name", System.getProperty("java.runtime.name"));
		appproperties.put("java.runtime.version", System.getProperty("java.runtime.version"));
		appproperties.put("java.vendor", System.getProperty("java.vendor"));
		appproperties.put("java.vendor.url", System.getProperty("java.vendor.url"));
		appproperties.put("java.version", System.getProperty("java.version"));
		appproperties.put(" java.version.date", System.getProperty(" java.version.date"));
		appproperties.put("sun.boot.library.path", System.getProperty("sun.boot.library.path"));
		appproperties.put("java.vm.name", environment.getProperty("java.vm.name"));
		appproperties.put("java.vm.vendor", environment.getProperty("java.vm.vendor"));
		appproperties.put("java.vm.version ", environment.getProperty("java.vm.version "));
		appproperties.put("java.vm.specification.name", environment.getProperty("java.vm.specification.name"));
		appproperties.put("ARTIFACT", buildProperties.getArtifact());
		appproperties.put("VSRION", buildProperties.getVersion());
		appproperties.put("PROJECT_PATH", Thread.currentThread().getContextClassLoader().getResource("").getPath());
		return appproperties;
		
	}
	
	@GetMapping("/dbinfo")
	public Object getDataBaseProperties() {
		try {
			 Map<String,Object> dbproperties = new LinkedHashMap();
			 DatabaseMetaData metaData= dataSorces.getConnection().getMetaData();
			 dbproperties.put("DATABASE_VENDER_NAME", metaData.getDatabaseProductName());
			 dbproperties.put("DATABASE_VENDER_VERSION", metaData.getDatabaseProductVersion());
			 dbproperties.put("DRIVER_NAME", metaData.getDriverName());
			 dbproperties.put("DRIVER_VSERSION", metaData.getDriverVersion());
			 dbproperties.put("DRIVER_MAJOR_VERSION", metaData.getDriverMajorVersion());
			 dbproperties.put("DRIVER_MINOR_VERSION", metaData.getDriverMinorVersion());
			 dbproperties.put("JDBC_MAJOR_VERSION", metaData.getJDBCMajorVersion());
			 dbproperties.put("JDBC_MMINOR_VERSION", metaData.getJDBCMinorVersion());
			 dbproperties.put("MAXIMUM_CONNECTIONS", metaData.getMaxConnections());
			 dbproperties.put("SCHEMA_TERMS", metaData.getSchemaTerm());
			 dbproperties.put("URL", metaData.getURL());
			 dbproperties.put("USERNAME", metaData.getUserName());
			 dbproperties.put("MONGO_DB", mongodburl);
			return dbproperties;  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error in reading data base properties";
		}
	}
	
}
