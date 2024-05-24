package com.School.Managements.details.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.Entity.StudentTest;
import com.School.Managements.details.Service.StudentTestService;

@RestController
@RequestMapping("/api")
public class StudentTestController {
	
	@Autowired
	
	StudentTestService studenttestservice;
	
	
	@PostMapping("/test")
	
	
	public StudentTest CreateTest(@RequestBody StudentTest studenttest) {
		return this.studenttestservice.CreateTestQuestion(studenttest);
	}
	
	@GetMapping("/test")
	
	public List<StudentTest> RetriveTest(){
		return this.studenttestservice.RetriveAllTest();
	}
	
}
