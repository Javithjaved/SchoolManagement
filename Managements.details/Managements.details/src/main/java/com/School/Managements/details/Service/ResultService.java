package com.School.Managements.details.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.School.Managements.details.Entity.Result;
import com.School.Managements.details.Entity.StudentTest;
import com.School.Managements.details.Repository.ResultRepository;
import com.School.Managements.details.Repository.StudentTestRepository;

@Service
public class ResultService {
	
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private StudentTestRepository studentTestRepository;

    public Result calculateResults(Long studentId) {
        List<StudentTest> studentTests = studentTestRepository.findByStudentId(studentId);
        Result result = new Result();
        if (!studentTests.isEmpty()) {
            result.setStudent(studentTests.get(0).getStudent());
            for (StudentTest studentTest : studentTests) {
                if (studentTest.getQuestionchoices() == null && studentTest.getQuestion() != null) {
                    studentTest.setQuestionchoices(studentTest.getQuestion().getQuestionchoices());
                }
            }
            result.setStudentTests(studentTests);
            resultRepository.save(result);
        }
        return result;
    }
	

}
