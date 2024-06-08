 package com.School.Managements.details.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "result")
public class Result {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name="resultId")
	    private Long id;
	 	@Column(name="studentId")
	    private Long studentId;
	 	@Column(name="totalpoints")
	    private Long totalPoints;
	    
	    @ManyToOne
	    private Tutor tutor;
	    
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Long getStudentId() {
	        return studentId;
	    }

	    public void setStudentId(Long studentId) {
	        this.studentId = studentId;
	    }
	    public Tutor getTutor() {
			return tutor;
		}

		public void setTutor(Tutor tutor) {
			this.tutor = tutor;
		}

		public Long getTotalPoints() {
	        return totalPoints;
	    }

	    public void setTotalPoints(Long totalPoints) {
	        this.totalPoints = totalPoints;
	    }
}