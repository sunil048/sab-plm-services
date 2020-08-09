/**
 * 
 */
package com.sabtok.plm.util;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author Sunil
 *
 * RestCalls.java Aug 7, 2020 1:34:55 PM
 */
public class RestCalls {

	private static RestTemplate restTemplate;
    private HttpEntity request;
	public  RestCalls(String username,String password){
		try {
		    // request url
		    String url = "https://jsonplaceholder.typicode.com/posts";
		    // create auth credentials
		    //String authStr = "Admin@123:Admin@123";
		    String authStr = "username:password";
		    String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
		    // create headers
		    HttpHeaders headers = new HttpHeaders();
		    headers.add("Authorization", "Basic " );
		  //  headers.setBasicAuth("admin", "admin");
		    headers.setBasicAuth(username, password);
		    // create request
		    request = new HttpEntity(headers);
		    
		  
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public String getData(String url) {
		  // make a request
	//    ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.GET, request, String.class);

	  ResponseEntity<String> response = RestConfig.getTemplate().getForEntity(url, String.class);
	    // get JSON response
	    String json = response.getBody();
	    return json;

	}
	
}
