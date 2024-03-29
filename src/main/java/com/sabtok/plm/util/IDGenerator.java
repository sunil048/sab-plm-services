/**
 * 
 */
package com.sabtok.plm.util;

import java.util.UUID;

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

	public  enum prefix {
	
		SAB,
		CAB
		
	}
	
	public static Long generateUserId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return Long.valueOf(randomPIN);
	}
	
	public static Long generateTaskId() {
		int randomPIN = (int)(Math.random()*900000000)+1000;
		return Long.valueOf(randomPIN);
	}
	
	public static String getIssueId1() {
	    ResponseEntity<String> response = RestConfig.getTemplate().getForEntity(AppConstants.USERMANAGEMENT_URL, String.class);
	    String json = response.getBody();
	    return prefix.SAB+json;

	}
	public static Long getIssueId() {
		int randomPIN = (int)(Math.random()*900000000)+1000;
		return Long.valueOf(randomPIN);
	}
	
	public static Integer getDocumentId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return Integer.valueOf(randomPIN);
	}
	
	public static Integer getReleaseId() {
		int randomPIN = (int)(Math.random()*900000000)+1000;
		return Integer.valueOf(randomPIN);
	}
	
	public static Long getLongId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return Long.valueOf(randomPIN);
	}
	
	public static Long getProjectId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return Long.valueOf(randomPIN);
	}
	
	public static Long getSkillId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return Long.valueOf(randomPIN);
	}
	
	public static int getItemId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return randomPIN;
	}
	
	public static int getBackItemId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return randomPIN;
	}
	public static int getSprintId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return randomPIN;
	}
	public static int getTestId() {
		int randomPIN = (int)(Math.random()*900000)+1000;
		return randomPIN;
	}
	
	public static UUID getUUID(){
		return UUID.randomUUID();
	}
	
	public static String getCommentId() {
		return UUID.randomUUID().toString();
	}
}
