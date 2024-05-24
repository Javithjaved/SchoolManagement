package com.School.Managements.details.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School.Managements.details.Entity.School;
import com.School.Managements.details.Repository.SchoolRepository;

@Service
public class SchoolService {
	@Autowired
	SchoolRepository schoolrepository;
	
	public School CreateNewSchool(final School school) {
		
		return this.schoolrepository.save(school);
	}
	public List<School> RetriveAllSchool() {
		return this.schoolrepository.findAll();
	}

}
