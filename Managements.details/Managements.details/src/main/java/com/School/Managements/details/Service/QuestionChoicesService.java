package com.School.Managements.details.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School.Managements.details.Entity.QuestionChoices;
import com.School.Managements.details.Repository.QuestionChoicesRepository;

@Service
public class QuestionChoicesService {

	@Autowired
	QuestionChoicesRepository questionchoicesrepository;

	public QuestionChoices CreateNewChoice(final QuestionChoices questionchoices) {
		return this.questionchoicesrepository.save(questionchoices);
	}

	public List<QuestionChoices> RetriveAllChoice() {
		return this.questionchoicesrepository.findAll();
	}

}
