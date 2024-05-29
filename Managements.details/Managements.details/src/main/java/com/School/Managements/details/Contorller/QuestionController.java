package com.School.Managements.details.Contorller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.Entity.Question;
import com.School.Managements.details.Service.QuestionService;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	QuestionService questionservice;

	@PostMapping
	public Question CreateQuestion(@RequestBody Question question) {
		return this.questionservice.CreateAllQuestion(question);

	}

	@GetMapping("/{id}")
	public Optional<Question> SingleIdfind(@PathVariable Long id) {
		return this.questionservice.SingleId(id);
	}

	@GetMapping
	public List<Question> RetriveQuestion() {
		return this.questionservice.RetriveAllQuestion();
	}
}
