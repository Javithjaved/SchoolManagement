package com.School.Managements.details.DTO;

public class ResponseTutorStudentMarkDTO {
	private Long Id;
	private Long StudentId;
	private Long TotalPoints;
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
	public Long getTotalPoints() {
		return TotalPoints;
	}
	public void setTotalPoints(Long totalPoints) {
		this.TotalPoints = totalPoints;
	}
	
}
