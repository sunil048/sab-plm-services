/**
 * 
 */
package com.sabtok.plm.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.util.DateUtils;

/**
 * @author Sunil
 *
 * UtilController.java Aug 10, 2020 9:45:56 AM
 */
@RestController
@RequestMapping("/util")
public class UtilController {

	@GetMapping("/getdate")
	public Object getDate() {
		Date date = DateUtils.getDate();
		return date;
	}
	
	@GetMapping("/getdatestring")
	public Object getDateString() {
		String date = DateUtils.getDateString();
		return date;
	}
}
