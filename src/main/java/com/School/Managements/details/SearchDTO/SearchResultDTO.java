package com.School.Managements.details.SearchDTO;

public class SearchResultDTO {
	private String TutorName;
	private String questiontext;
	private String StudentName;
	private Long TotalPoints;
	public String getTutorName() {
		return TutorName;
	}
	public void setTutorName(String tutorName) {
		this.TutorName = tutorName;
	}
	public String getQuestiontext() {
		return questiontext;
	}
	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		this.StudentName = studentName;
	}
	public Long getTotalPoints() {
		return TotalPoints;
	}
	public void setTotalPoints(Long totalPoints) {
		this.TotalPoints = totalPoints;
	}
	
}
