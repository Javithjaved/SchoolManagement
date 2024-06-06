package com.School.Managements.details.Contorller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.DTO.ResponsePaginationDTO;
import com.School.Managements.details.DTO.ResponseSchoolDTO;
import com.School.Managements.details.Entity.School;
import com.School.Managements.details.Service.SchoolService;

@RestController
@RequestMapping("/api/school")
public class SchoolController {
	@Autowired
	SchoolService schoolservice;

	@PostMapping
	public School createSchool(@RequestBody School school) {
		return this.schoolservice.CreateNewSchool(school);
	}

	@GetMapping
	public List<School> RetriveSchool() {
		return this.schoolservice.RetriveAllSchool();

	}

	@GetMapping("/pagination")
	public List<ResponseSchoolDTO> getNextPage(ResponsePaginationDTO paginationDTO) {
		return this.schoolservice.getNextPage(paginationDTO.getPageno(), paginationDTO.getPagesize());
	}

	@GetMapping("/search")
	public List<ResponseSchoolDTO> Search(@RequestParam String schoolName,Long schoolId) {
		return this.schoolservice.SearchAllSchool(schoolName,schoolId);
	}
}
