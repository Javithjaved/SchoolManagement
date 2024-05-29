package com.School.Managements.details.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School.Managements.details.Entity.StudentTest;
import com.School.Managements.details.Repository.QuestionRepository;
import com.School.Managements.details.Repository.StudentTestRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentTestService {

	@Autowired
	StudentTestRepository studentTestRepository;

	@Autowired
	QuestionRepository questionRepository;

	public StudentTest createTestQuestion(StudentTest studentTest) {
		studentTest.setQuestion(this.questionRepository.findById(studentTest.getQuestion().getId()).orElseThrow());
		return this.studentTestRepository.save(studentTest);
	}

	public List<StudentTest> RetriveAllTest() {
		return this.studentTestRepository.findAll();
	}

}
