package com.School.Managements.details.Contorller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.School.Managements.details.DTO.ResponsePaginationDTO;
import com.School.Managements.details.DTO.ResponseStudentDTO;
import com.School.Managements.details.Entity.Student;
import com.School.Managements.details.Service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return this.studentService.createStudent(student);
	}

	@GetMapping
	public List<ResponseStudentDTO> retrieveStudent(ResponsePaginationDTO responsePaginationDTO) {
		return this.studentService.retrieveAllStudent(responsePaginationDTO.getPageno(),
				responsePaginationDTO.getPagesize());
	}

	@GetMapping("/all")
	public List<Student> retrivestudent() {
		return this.studentService.retriveallstudent();
	}

	@GetMapping("/search")
	public List<ResponseStudentDTO> searchStudent(@RequestParam(required = false) String studentName,
			@RequestParam(required = false) String schoolName, @RequestParam(required = false) String location) {
		return this.studentService.searchStudentData(studentName, schoolName, location);
	}
}
