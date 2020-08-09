/**
 * 
 */
package com.sabtok.plm.util;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

/**
 * @author Sunil
 *
 * JsonUtil.java Aug 9, 2020 10:35:31 AM
 */
public class JsonUtil {

	public static Object converStringToMap(String jsonData){
		
		ObjectMapper mapper = new ObjectMapper();
		 try {
			return mapper.readValue(jsonData, Map.class);
		} catch (IOException e) {
			return "Error in parsing data";
		}
	}
	
public static <T> Object converStringToObject(String jsonData,Class<T> t) {
		
		ObjectMapper mapper = new ObjectMapper();
		 try {
			return mapper.readValue(jsonData, t);
		} catch (IOException e) {
			e.printStackTrace();
			return "Error in parsing data";
		}
	}
}
