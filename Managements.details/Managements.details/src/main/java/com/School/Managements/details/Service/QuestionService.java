package com.School.Managements.details.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School.Managements.details.Entity.Question;
import com.School.Managements.details.Repository.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionrespository;

	public Question CreateAllQuestion(final Question question) {
		return this.questionrespository.save(question);
	}

	public List<Question> RetriveAllQuestion() {
		return this.questionrespository.findAll();
	}

	public Optional<Question> SingleId(Long id) {
		return this.questionrespository.findById(id);
	}
}
