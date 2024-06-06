package com.School.Managements.details.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.School.Managements.details.DTO.ResponseSchoolDTO;
import com.School.Managements.details.Entity.School;
import com.School.Managements.details.Repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	SchoolRepository schoolRepository;

	public School CreateNewSchool(School school) {
		return this.schoolRepository.save(school);
	}

	public List<ResponseSchoolDTO> getNextPage(int pageno, int pagesize) {
		PageRequest pageable = PageRequest.of(pageno, pagesize);
		Page<School> pagination = schoolRepository.findAll(pageable);
		List<School> schools = pagination.getContent();
		List<ResponseSchoolDTO> responseSchoolDTOs = new ArrayList<>();

		for (School school : schools) {
			ResponseSchoolDTO responseSchoolDTO = new ResponseSchoolDTO();
			responseSchoolDTO.setId(school.getId());
			responseSchoolDTO.setSchoolName(school.getSchoolName());
			responseSchoolDTOs.add(responseSchoolDTO);
		}
		return responseSchoolDTOs;
	}

	public List<School> RetriveAllSchool() {
		return this.schoolRepository.findAll();
	}

	public List<ResponseSchoolDTO> SearchAllSchool(String schoolName, Long schoolId) {
		List<School> schoolList = schoolRepository.findBySchoolName(schoolName, schoolId);
		List<ResponseSchoolDTO> dtos = new ArrayList<>();
		for (School school : schoolList) {
			ResponseSchoolDTO responseSchoolDTO = new ResponseSchoolDTO();
			responseSchoolDTO.setId(school.getId());
			responseSchoolDTO.setSchoolName(school.getSchoolName());
			dtos.add(responseSchoolDTO);
		}
		return dtos;
	}

}