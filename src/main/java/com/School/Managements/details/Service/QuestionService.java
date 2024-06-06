package com.School.Managements.details.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.School.Managements.details.DTO.ResponseQuestionDTO;
import com.School.Managements.details.Entity.Question;
import com.School.Managements.details.Repository.QuestionRepository;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public Question CreateAllQuestion(final Question question) {
        return this.questionRepository.save(question);
    }

    public List<Question> RetriveAllQuestion() {
        return this.questionRepository.findAll();
    }

    public Optional<Question> SingleId(Long id) {
        return this.questionRepository.findById(id);
    }

    public List<ResponseQuestionDTO> RetriveAllDtoQuestion(int pageno, int pagesize) {
        Pageable pageable = PageRequest.of(pageno, pagesize);
        Page<Question> pagedQuestionData = questionRepository.findAll(pageable);
        List<Question> questionList = pagedQuestionData.getContent();
        List<ResponseQuestionDTO> responseDTOs = new ArrayList<>();
        for (Question question : questionList) {
            ResponseQuestionDTO responseQuestionDTO = new ResponseQuestionDTO();
            responseQuestionDTO.setId(question.getId());
            responseQuestionDTO.setTutorId(question.getTutor().getId());
            responseQuestionDTO.setQuestionText(question.getQuestionText());
            responseDTOs.add(responseQuestionDTO);
        }
        return responseDTOs;
    }

	public List<ResponseQuestionDTO> SearchQuestions(String questiontext) {
		List<Question> questions= questionRepository.findByQuestion(questiontext);
		List<ResponseQuestionDTO> dtos=new ArrayList<ResponseQuestionDTO>();
		for(Question question : questions) {
			ResponseQuestionDTO questionDTO= new ResponseQuestionDTO();
			questionDTO.setId(question.getId());
			questionDTO.setTutorId(question.getTutor().getId());
			questionDTO.setQuestionText(question.getQuestionText());
			dtos.add(questionDTO);
		}
		return dtos;
	}
}