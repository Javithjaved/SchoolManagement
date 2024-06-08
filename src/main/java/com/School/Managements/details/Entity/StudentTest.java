package com.School.Managements.details.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="test")
public class StudentTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
    @Column(name="testid")
    private Long id;
    @Column(name="subjectname")
    private String SubjectName;
    @ManyToOne
    private Student student;

    @ManyToOne
    private Question question;
  
    @ManyToOne
    private QuestionChoices questionChoices;
   
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
    
	public QuestionChoices getQuestionChoices() {
		return questionChoices;
	}

	public void setQuestionChoices(QuestionChoices questionChoices) {
		this.questionChoices = questionChoices;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		this.SubjectName = subjectName;
	}

}
