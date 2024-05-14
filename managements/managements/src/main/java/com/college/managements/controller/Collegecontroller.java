package com.college.managements.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.managements.entity.College;
import com.college.managements.service.Collegeservice;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class Collegecontroller {
	@Autowired
	Collegeservice CollegeService;
	
	@PostMapping("/college")
	public College CreateCollege(@RequestBody College collge) {
		return this.CollegeService.CreateCollege(collge);
	}
	@GetMapping("/college")
	public List<College> retrieveCollegeDetail(){
		return this.CollegeService.retrieveCollege();
	}	     
	
	 @DeleteMapping("/college/{id}")
	    public String deleteCollege(@PathVariable("id") long id) {
	        return this.CollegeService.deleteCollegeDetail(id);
	    }
	 @PutMapping("/college/{id}")
	    public String editCollege(@PathVariable("id") long id, @RequestBody College college) {
	        return this.CollegeService.editCollegeDetail(id, college);
	 }
}
