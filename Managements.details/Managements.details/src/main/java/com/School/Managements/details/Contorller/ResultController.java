package com.School.Managements.details.Contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.Entity.Result;
import com.School.Managements.details.Service.ResultService;

@RestController
@RequestMapping("/api")
public class ResultController {
	
	@Autowired 
	
	ResultService resultservice;
    @GetMapping("/calculate/{studentId}")
    public Result calculateResult(@PathVariable Long studentId) {
        return resultservice.calculateResults(studentId);
    }

}
