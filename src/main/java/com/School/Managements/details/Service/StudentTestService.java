package com.School.Managements.details.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.School.Managements.details.DTO.ResponseTestDTO;
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

	public List<ResponseTestDTO> RetriveAllTest(int Pageno, int Pagesize) {
		Pageable pageable = PageRequest.of(Pageno, Pagesize);
		Page<StudentTest> pagedTestData = studentTestRepository.findAll(pageable);
		List<StudentTest> testList = pagedTestData.getContent();
		List<ResponseTestDTO> responseDTOs = new ArrayList<>();
		for (StudentTest studentTest : testList) {
			ResponseTestDTO responseTestDTO = new ResponseTestDTO();
			responseTestDTO.setId(studentTest.getId());
			responseTestDTO.setQuestionId(studentTest.getQuestion().getId());
			responseTestDTO.setStudentId(studentTest.getStudent().getId());
			responseTestDTO.setSubjectName(studentTest.getSubjectName());
			responseDTOs.add(responseTestDTO);
		}
		return responseDTOs;
	}
}