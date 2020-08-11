/**
 * 
 */
package com.sabtok.plm.service;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author Sunil
 *
 * ProjectService.java Aug 9, 2020 5:30:04 PM
 */
@Service
public interface ProjectService {

	public List<String> getProjectNames();
}
