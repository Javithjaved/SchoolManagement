package com.School.Managements.details.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.School.Managements.details.DTO.ResponseChoicesDTO;
import com.School.Managements.details.Entity.QuestionChoices;
import com.School.Managements.details.Repository.QuestionChoicesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionChoicesService {

    @Autowired
    QuestionChoicesRepository questionchoicesrepository;

    public QuestionChoices CreateNewChoice(final QuestionChoices questionchoices) {
        return this.questionchoicesrepository.save(questionchoices);
    }

    public List<ResponseChoicesDTO> RetriveAllChoice(int pageno, int pagesize) {
        Pageable pageable = PageRequest.of(pageno, pagesize);
        List<QuestionChoices> questionchoices = questionchoicesrepository.findAll(pageable).getContent();
        List<ResponseChoicesDTO> questiondto = new ArrayList<>();
        for (QuestionChoices questionchoice : questionchoices) {
            ResponseChoicesDTO resposnsechoicesdto = new ResponseChoicesDTO();
            resposnsechoicesdto.setId(questionchoice.getId());
            resposnsechoicesdto.setChoices(questionchoice.getChoices());
            questiondto.add(resposnsechoicesdto);
        }
        return questiondto;
    }

}