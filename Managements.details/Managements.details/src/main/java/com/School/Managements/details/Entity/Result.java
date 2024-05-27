package com.School.Managements.details.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Student student;

    @OneToMany
    private List<StudentTest> studentTests;

    private Long totalPoints;

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

	public Long getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(Long totalPoints) {
		this.totalPoints = totalPoints;
	}

	public List<StudentTest> getStudentTests() {
		return studentTests;
	}

	public void setStudentTests(List<StudentTest> studentTests) {
        this.studentTests = studentTests;
        calculateTotalPoints();
    }
	private void calculateTotalPoints() {
	    this.totalPoints = studentTests.stream()
	            .mapToLong(studentTest -> {
	                if (studentTest.getQuestionchoices() != null) {
	                    return studentTest.getQuestionchoices().getPoint();
	                }
	                return 0L;
	            })
	            .sum();
	}

}
