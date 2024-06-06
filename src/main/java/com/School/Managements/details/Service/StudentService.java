package com.School.Managements.details.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.School.Managements.details.DTO.ResponseStudentDTO;
import com.School.Managements.details.Entity.Student;
import com.School.Managements.details.Repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(final Student student) {
        return this.studentRepository.save(student);
    }

    public List<ResponseStudentDTO> retrieveAllStudent(int pageno, int pagesize) {
        PageRequest pageable = PageRequest.of(pageno, pagesize);
        Page<Student> pagedStudentData = studentRepository.findAll(pageable);
        List<Student> studentList = pagedStudentData.getContent();
        List<ResponseStudentDTO> responseStudentDTOs = new ArrayList<>();
        for (Student student : studentList) {
            ResponseStudentDTO responseStudentDTO = new ResponseStudentDTO();
            responseStudentDTO.setId(student.getId());
            responseStudentDTO.setStudentId(student.getSchool().getId());
            responseStudentDTOs.add(responseStudentDTO);
        }
        return responseStudentDTOs;
    }

    public List<Student> retriveallstudent() {
        return this.studentRepository.findAll();
    }

    public List<ResponseStudentDTO> searchStudentData(String studentName, String schoolName, String location) {
        List<Student> students = studentRepository.findStudentsBySearchParameters(studentName, schoolName, location);
        List<ResponseStudentDTO> dtos = new ArrayList<>();
        for (Student student : students) {
            ResponseStudentDTO responseStudentDTO = new ResponseStudentDTO();
            responseStudentDTO.setId(student.getId());
            responseStudentDTO.setStudentId(student.getSchool().getId());
            dtos.add(responseStudentDTO);
        }
        return dtos;
    }
}
