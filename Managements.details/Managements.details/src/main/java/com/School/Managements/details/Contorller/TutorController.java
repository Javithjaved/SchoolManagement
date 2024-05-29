package com.School.Managements.details.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.Entity.Tutor;
import com.School.Managements.details.Service.TutorService;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {

	@Autowired

	TutorService tutorservice;

	@PostMapping
	public Tutor CreateNewTutor(@RequestBody Tutor tutor) {
		return this.tutorservice.CreateTutor(tutor);

	}

	@GetMapping
	public List<Tutor> RetriveTutor() {
		return this.tutorservice.RetraiveAllTutor();

	}
}
