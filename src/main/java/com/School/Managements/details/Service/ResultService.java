package com.School.Managements.details.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.School.Managements.details.DTO.ResponseResultDTO;
import com.School.Managements.details.Entity.Question;
import com.School.Managements.details.Entity.QuestionChoices;
import com.School.Managements.details.Entity.Result;
import com.School.Managements.details.Entity.StudentTest;
import com.School.Managements.details.Entity.Tutor;
import com.School.Managements.details.Repository.ResultRepository;
import com.School.Managements.details.Repository.StudentTestRepository;

@Service
public class ResultService {
	@Autowired
    StudentTestRepository studentTestRepository;

    @Autowired
    ResultRepository resultRepository;

    public Long calculateScore(Long studentId) {
        List<StudentTest> studentTests = studentTestRepository.findByStudentId(studentId);
        Long totalPoints = 0L;
        for (StudentTest studentTest : studentTests) {
            Question question = studentTest.getQuestion();
            if (question != null) {
                QuestionChoices questionChoices = studentTest.getQuestionChoices();
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

    public List<ResponseResultDTO> RetriveAllStudent(int pageno, int pagesize) {
        Pageable pageable = PageRequest.of(pageno, pagesize);
        Page<Result> pagedResultData = resultRepository.findAll(pageable);
        List<Result> resultList = pagedResultData.getContent();

        List<ResponseResultDTO> responseResultDTOs = new ArrayList<>();
        for (Result result : resultList) {
            ResponseResultDTO responseResultDTO = new ResponseResultDTO();
            responseResultDTO.setId(result.getId());
            responseResultDTO.setStudentId(result.getStudentId());
            responseResultDTO.setTotalPoints(result.getTotalPoints());
            responseResultDTOs.add(responseResultDTO);
        }
        return responseResultDTOs;
    }
}