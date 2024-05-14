package com.college.managements.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.managements.entity.College;
import com.college.managements.repository.CollegeRepository;

@Service
public class Collegeservice {
	
	@Autowired
	CollegeRepository CollegeRepositors;

	public College CreateCollege(final College college) {
		return this.CollegeRepositors.save(college);
	}
	
	public List<College> retrieveCollege(){
		return this.CollegeRepositors.findAll();
	}
	
	 public String deleteCollegeDetail(long id) {
	        	CollegeRepositors.deleteById(id);
	            return "Success data";    
	    }
	 
	 public College editCollegeDetail(long id, College college) throws AccountNotFoundException {
//	        College collegeData = CollegeRepositors.findById(id).orElseThrow();
//	        if (collegeData==null) {
//	            return "College not found";
//	        }
//	        collegeData.setName(college.getName());
//	        collegeData.setEmail(college.getEmail());
//	        collegeData.setAddress(college.getAddress());
//	        CollegeRepositors.save(collegeData);
//	        return "Success Your data has been updated.";  
		 Optional <College> CollegeData=CollegeRepositors.findById(id);
		 if(CollegeData.isEmpty()) {
			 throw new AccountNotFoundException("User Not Found");
		 }
		 College finalCollege=CollegeData.orElseThrow();
		 if(college.getEmail()!=null) {
			 finalCollege.setEmail(college.getEmail());
		 }
		 if(college.getAddress()!=null) {
			 finalCollege.setAddress(college.getAddress());
		 }
		return this.CollegeRepositors.save(finalCollege);
	    }
}

