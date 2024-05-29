package com.School.Managements.details.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.Entity.Student;
import com.School.Managements.details.Service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	
	StudentService studentserivce;
	
	
	@PostMapping
	public Student CraeteStudent(@RequestBody Student student) {
		return this.studentserivce.CreateStudent(student);
	}
	@GetMapping
	
	public List<Student> RetriveStudent(){
		return this.studentserivce.RetriveAllStudent();
	}
}

