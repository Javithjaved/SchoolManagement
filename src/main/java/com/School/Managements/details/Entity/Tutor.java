package com.School.Managements.details.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")
    @Column(name = "TutorId")
    private Long Id;
    @Column(name = "TutorName")
    private String TutorName;
    @ManyToOne
    private Result result;
    
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getTutorName() {
        return TutorName;
    }

    public void setTutorName(String tutorName) {
        this.TutorName = tutorName;
    }

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
