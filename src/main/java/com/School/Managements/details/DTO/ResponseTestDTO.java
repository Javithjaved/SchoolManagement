package com.School.Managements.details.DTO;

public class ResponseTestDTO {
	private Long Id;
	private Long  StudentId;
	private Long QuestionId;
	private String SubjectName;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	public Long getStudentId() {
		return StudentId;
	}
	public void setStudentId(Long studentId) {
		this.StudentId = studentId;
	}
	public Long getQuestionId() {
		return QuestionId;
	}
	public void setQuestionId(Long questionId) {
		this.QuestionId = questionId;
	}

	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		this.SubjectName = subjectName;
	}
}
