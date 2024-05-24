package com.School.Managements.details.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School.Managements.details.Entity.StudentTest;
import com.School.Managements.details.Repository.StudentTestRepository;

@Service
public class StudentTestService {
	
	@Autowired
	
	StudentTestRepository studenttestrepository;

	public StudentTest CreateTestQuestion(StudentTest studenttest) {
		return this.studenttestrepository.save(studenttest);
	}

	public List<StudentTest> RetriveAllTest() {
		return this.studenttestrepository.findAll();
	}

}
