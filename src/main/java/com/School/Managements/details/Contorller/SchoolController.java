package com.School.Managements.details.Contorller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.School.Managements.details.DTO.ResponsePaginationDTO;
import com.School.Managements.details.DTO.ResponseSchoolDTO;
import com.School.Managements.details.Entity.School;
import com.School.Managements.details.Service.SchoolService;

@RestController
@RequestMapping("/api/school")
@CrossOrigin(origins = "http://localhost:3001/")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return this.schoolService.createNewSchool(school);
    }

    @GetMapping
    public List<School> retrieveSchool() {
        return this.schoolService.retrieveAllSchool();
    }

    @GetMapping("/pagination")
    public List<ResponseSchoolDTO> getNextPage(@RequestBody ResponsePaginationDTO paginationDTO) {
        return this.schoolService.getNextPage(paginationDTO.getPageno(), paginationDTO.getPagesize());
    }

    @GetMapping("/search")
    public List<ResponseSchoolDTO> search(
        @RequestParam(required = false) String schoolName,
        @RequestParam(required = false) Long schoolId,
        @RequestParam int pageno,
        @RequestParam int pagesize,
        @RequestParam String sortField,
        @RequestParam String sortDirection) {
        return schoolService.searchAllSchool(schoolName, schoolId, pageno, pagesize, sortField, sortDirection);
    }
}