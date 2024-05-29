package com.School.Managements.details.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.School.Managements.details.Entity.Question;
import com.School.Managements.details.Entity.QuestionChoices;
import com.School.Managements.details.Entity.Result;
import com.School.Managements.details.Entity.StudentTest;
import com.School.Managements.details.Repository.ResultRepository;
import com.School.Managements.details.Repository.StudentTestRepository;

@Service
public class ResultService {

    @Autowired
    StudentTestRepository studentTestRepository;
    
    @Autowired
    ResultRepository resultRepository;

    public int calculateScore(Long studentId) {
        List<StudentTest> studentTests = studentTestRepository.findByStudentId(studentId);
        int totalPoints = 0;
        for (StudentTest studentTest : studentTests) {
            Question question = studentTest.getQuestion();
            if (question != null) {
                QuestionChoices questionChoices = question.getQuestionchoices();
                if (questionChoices != null && questionChoices.getIsCorrect()) {
                    totalPoints += questionChoices.calculatePoints();
                }
            }
        }
        Result result = new Result();
        result.setStudentId(studentId);
        result.setTotalPoints(totalPoints);
        resultRepository.save(result);
        return totalPoints;
    }

    public List<StudentTest> RetriveAllStudent() {
        return studentTestRepository.findAll();
    }
}
