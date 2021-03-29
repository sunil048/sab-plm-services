/**
 * 
 */
package com.sabtok.plm.util;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sunil
 *
 * SystemCalls.java Mar 16, 2021 1:18:57 PM
 */
@RestController
public class SystemCalls {

	@GetMapping("/status")
	public String getServiceStatus()
	{
		return "Service is up and running....";
	}
}
