package com.School.Managements.details.Contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.School.Managements.details.DTO.ResponseChoicesDTO;
import com.School.Managements.details.DTO.ResponsePaginationDTO;
import com.School.Managements.details.Entity.QuestionChoices;
import com.School.Managements.details.Service.QuestionChoicesService;

@RestController
@RequestMapping("/api/choice")
public class QuestionChoicesController {
	@Autowired

	QuestionChoicesService questionchoicesservice;

	@PostMapping
	public QuestionChoices createChoice(@RequestBody QuestionChoices questionchoices) {
		return this.questionchoicesservice.CreateNewChoice(questionchoices);

	}

	@GetMapping
	public List<ResponseChoicesDTO> RetriveChoice(ResponsePaginationDTO responsePaginationDTO) {
		return this.questionchoicesservice.RetriveAllChoice(responsePaginationDTO.getPageno(),responsePaginationDTO.getPagesize());

	}
}
