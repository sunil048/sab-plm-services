/**
 * 
 */
package com.sabtok.plm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabtok.plm.entity.Skill;
import com.sabtok.plm.service.SkillService;

/**
 * @author Sunil
 *
 * SkillController.java Aug 9, 2020 6:38:11 PM
 */
@CrossOrigin("http://localhost:5000")
@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@GetMapping("/skillnames")
	public List <String> getSkillNames(){
		return skillService.getSkillNames();
	}
	
	@GetMapping("/list")
	public List<Skill> getSkillList(){
		return skillService.getSkillList();
	}
	
}
