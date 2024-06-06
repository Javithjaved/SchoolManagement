package com.School.Managements.details.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.DTO.ResponsePaginationDTO;
import com.School.Managements.details.DTO.ResponseTestDTO;
import com.School.Managements.details.Entity.StudentTest;
import com.School.Managements.details.Service.StudentTestService;

@RestController
@RequestMapping("/api")
public class StudentTestController {

	@Autowired
	StudentTestService studentTestService;

	@PostMapping("/create-student-test")
	public StudentTest CreateTest(@RequestBody final StudentTest studentTest) {
		return this.studentTestService.createTestQuestion(studentTest);
	}
	
	@GetMapping("/test")
	public List<ResponseTestDTO> RetriveTest(ResponsePaginationDTO responsePaginationDTO) {
		return this.studentTestService.RetriveAllTest(responsePaginationDTO.getPageno(),responsePaginationDTO.getPagesize());
	}

}
