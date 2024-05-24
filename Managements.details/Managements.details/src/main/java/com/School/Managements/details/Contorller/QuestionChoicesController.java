package com.School.Managements.details.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.Entity.QuestionChoices;
import com.School.Managements.details.Service.QuestionChoicesService;

@RestController
@RequestMapping("/api")
public class QuestionChoicesController {
	@Autowired
	
	QuestionChoicesService questionchoicesservice;
	@PostMapping("/choice")
	public QuestionChoices createChoice(@RequestBody QuestionChoices questionchoices) {
		return this.questionchoicesservice.CreateNewChoice(questionchoices);
		
	}
	
	@GetMapping("/choice")
	public List<QuestionChoices> RetriveChoice(){
		return this.questionchoicesservice.RetriveAllChoice();
		
	}
}
