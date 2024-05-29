package com.School.Managements.details.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School.Managements.details.Entity.Student;
import com.School.Managements.details.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired

	StudentRepository studentRepository;

	public Student CreateStudent(final Student student) {
		return this.studentRepository.save(student);
	}

	public List<Student> RetriveAllStudent() {
		return this.studentRepository.findAll();
	}

}
