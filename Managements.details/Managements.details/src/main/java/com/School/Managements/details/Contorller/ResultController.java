package com.School.Managements.details.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.School.Managements.details.Entity.StudentTest;
import com.School.Managements.details.Repository.StudentTestRepository;
import com.School.Managements.details.Service.ResultService;

@RestController
@RequestMapping("/api/result")
public class ResultController {

	@Autowired
	ResultService resultservice;

	@Autowired

	StudentTestRepository studentTestRepository;

	@GetMapping("/{studentId}")
	public int calculateResult(@PathVariable Long studentId) {
		return resultservice.calculateScore(studentId);
	}

	@GetMapping("/tutor")
	public List<StudentTest> RetriveStudent() {
		return this.resultservice.RetriveAllStudent();

	}

}
