package com.School.Managements.details.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
	@Column(name="question_id")
	private long id;
	@Column(name="question_text")
	private String questionText;
	
	@ManyToOne
	private Tutor tutor;

	@ManyToOne
	private QuestionChoices questionchoices;

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public QuestionChoices getQuestionchoices() {
		return questionchoices;
	}

	public void setQuestionchoices(QuestionChoices questionchoices) {
		this.questionchoices = questionchoices;
	}

	public long getPoints() {
		return this.questionchoices.calculatePoints();
	}
}
