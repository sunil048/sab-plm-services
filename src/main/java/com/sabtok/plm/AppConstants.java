/**
 * 
 */
package com.sabtok.plm;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value; 

/**
 * @author Sunil
 *
 * Constants.java Aug 6, 2020 11:45:00 AM
 */
@Configuration
public class AppConstants {
	
	public static final String MONGO_DB_URL="192.168.92.137";
	public static final String MONGO_PORT="27017";
	public static final String MONGO_USER="";
	public static final String MONGO_PASSWORD="";
	public static final String MONGODB="mongodb://dev:dev@192.168.92.137:27017/test";	
	public static String USERMANAGEMENT_URL;
	public static String USERMANAGEMENT_USERNAME;
	public static String USERMANAGEMENT_PASSWORD;
	public static String DATE_FORMATE;
	
	@Value("${sabtok.userservice.url}") //Since value can not inject values to static fields directly
	public void setUrl(String url) {
		USERMANAGEMENT_URL = url;
	}
	
	@Value("${sabtok.userservice.user}")
	public void setUserName(String uname) {
		USERMANAGEMENT_USERNAME = uname;
	}
	
	@Value("${sabtok.userservice.password}")
	public void setPassword(String password) {
		USERMANAGEMENT_PASSWORD = password;
	}
	
	@Value("${sabtok.userservice.password}")
	public void setDateFormate(String dateFormate) {
		DATE_FORMATE = dateFormate;
	}
	
	/*
	 * 
	 * public class PropertiesExtractor {
     private static Properties properties;
     static {
        properties = new Properties();
        URL url = new PropertiesExtractor().getClass().getClassLoader().getResource("application.properties");
        try{
            properties.load(new FileInputStream(url.getPath()));
           } catch (FileNotFoundException e) {
                e.printStackTrace();
           }
        }

        public static String getProperty(String key){
            return properties.getProperty(key);
        }
}
	 * 
	 * 
	 */
	
	public  enum ResponseStatus {
		
		SUCCESS
	}
}
