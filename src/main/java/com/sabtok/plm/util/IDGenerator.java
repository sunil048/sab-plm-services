/**
 * 
 */
package com.sabtok.plm.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sabtok.plm.AppConstants;

/**
 * @author Sunil
 *
 * IDGenerator.java Aug 7, 2020 12:26:05 PM
 */
public class IDGenerator {

	enum prefix {
	
		SAB,
		CAB
		
	}
	
	public static Long generateUserId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return Long.valueOf(randomPIN);
	}
	
	public static Long generateTaskId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return Long.valueOf(randomPIN);
	}
	
	public static String getIssueId() {
	    ResponseEntity<String> response = RestConfig.getTemplate().getForEntity(AppConstants.USERMANAGEMENT_URL, String.class);
	    String json = response.getBody();
	    return prefix.SAB+json;

	}
}