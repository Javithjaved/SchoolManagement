package com.School.Managements.details.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentTest {
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	
	private Long id;
	
	@ManyToOne
	
	private Student student;
	
	@ManyToOne
	
	private Question question;
	
	@ManyToOne
	
	private QuestionChoices questionchoices;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public QuestionChoices getQuestionchoices() {
		return questionchoices;
	}

	public void setQuestionchoices(QuestionChoices questionchoices) {
		this.questionchoices = questionchoices;
	}
}
