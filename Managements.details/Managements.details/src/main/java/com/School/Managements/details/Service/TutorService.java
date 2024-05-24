package com.School.Managements.details.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School.Managements.details.Entity.Tutor;
import com.School.Managements.details.Repository.TutorRepository;

@Service
public class TutorService {

	
	@Autowired
	
	TutorRepository tutorrepository;

	public Tutor CreateTutor(final Tutor tutor) {
		return this.tutorrepository.save(tutor);
	}

	public List<Tutor> RetraiveAllTutor() {
		return this.tutorrepository.findAll();
	}
	
	
	
}
