package com.School.Managements.details.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.School.Managements.details.DTO.ResponsePaginationDTO;
import com.School.Managements.details.DTO.ResponseResultDTO;
import com.School.Managements.details.Entity.Result;
import com.School.Managements.details.Entity.StudentTest;
import com.School.Managements.details.Repository.StudentTestRepository;
import com.School.Managements.details.SearchDTO.SearchResultDTO;
import com.School.Managements.details.Service.ResultService;
import com.School.Managements.details.Service.StudentTestService;

@RestController
@RequestMapping("/api/result")
public class ResultController {

	@Autowired
	ResultService resultservice;

	@Autowired

	StudentTestRepository studentTestRepository;
	@Autowired
	
	StudentTestService studentTestService;

	@GetMapping("/{studentId}")
	public Long calculateResult(@PathVariable Long studentId) {
		return resultservice.calculateScore(studentId);
	}

	@GetMapping("/tutor")
	public List<ResponseResultDTO> RetriveStudent(ResponsePaginationDTO responsePaginationDTO) {
		return this.resultservice.RetriveAllStudent(responsePaginationDTO.getPageno(),responsePaginationDTO.getPagesize());

	}
}
