/**
 * 
 */
package com.sabtok.plm.util;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.sabtok.plm.AppConstants;

/**
 * @author Sunil
 *
 * RestConfig.java Aug 7, 2020 1:59:32 PM
 */
public class RestConfig {

	public static RestTemplate restTemplate;
	
	public RestConfig() {
		
		restTemplate = new RestTemplate(getClientHttpRequestFactory());
		
	}
	
	 private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() 
	    {
	        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	                          = new HttpComponentsClientHttpRequestFactory();
	         
	        clientHttpRequestFactory.setHttpClient(httpClient());
	              
	        return clientHttpRequestFactory;
	    }
	     
	    private HttpClient httpClient() 
	    {
	        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
	 
	        credentialsProvider.setCredentials(AuthScope.ANY, 
	                        new UsernamePasswordCredentials(AppConstants.USERMANAGEMENT_USERNAME, AppConstants.USERMANAGEMENT_PASSWORD));
	       // credentialsProvider.setCredentials(AuthScope.ANY, 
           //         new UsernamePasswordCredentials("Admin@123", "Admin@123"));
	        
	        HttpClient client = HttpClientBuilder
	                                .create()
	                                .setDefaultCredentialsProvider(credentialsProvider)
	                                .build();
	        return client;
	    }
	
	    public static RestTemplate getTemplate() {
	    	if (restTemplate == null)
	    		new RestConfig();
	    	return restTemplate;
	    }
}
