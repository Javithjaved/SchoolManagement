package com.School.Managements.details.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.Entity.School;
import com.School.Managements.details.Service.SchoolService;

@RestController
@RequestMapping("/api")
public class SchoolController {
	
	@Autowired 
	
	SchoolService schoolservice;
    @PostMapping("/school")
	public School createSchool(@RequestBody School school) {
		return this.schoolservice.CreateNewSchool(school);
		
	}
    
    @GetMapping("/school")
    
    public List<School> RetriveSchool(){
		return this.schoolservice.RetriveAllSchool();
    	
    }

}
