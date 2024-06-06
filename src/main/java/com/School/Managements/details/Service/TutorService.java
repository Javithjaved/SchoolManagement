package com.School.Managements.details.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.School.Managements.details.DTO.ResponseTutorStudentMarkDTO;
import com.School.Managements.details.DTO.ResposnseTutorDTO;
import com.School.Managements.details.Entity.Tutor;
import com.School.Managements.details.Repository.ResultRepository;
import com.School.Managements.details.Repository.TutorRepository;

@Service
public class TutorService {

    @Autowired
    TutorRepository tutorRepository;

    @Autowired
    ResultRepository resultRepository;

    public Tutor createTutor(final Tutor tutor) {
        return this.tutorRepository.save(tutor);
    }
    public List<ResponseTutorStudentMarkDTO> retrieveAllTutorStudents() {
        List<Tutor> tutorData = tutorRepository.findAll();
        List<ResponseTutorStudentMarkDTO> dtos = new ArrayList<>();
        for (Tutor tutor : tutorData) {
            ResponseTutorStudentMarkDTO responseTutorDTO = new ResponseTutorStudentMarkDTO();
            responseTutorDTO.setId(tutor.getId());
            if (tutor.getResult() != null) {
                responseTutorDTO.setTotalPoints(tutor.getResult().getTotalPoints());
                responseTutorDTO.setStudentId(tutor.getResult().getStudentId());
            }
            dtos.add(responseTutorDTO);
        }
        return dtos;
    }

	public List<ResposnseTutorDTO> RetraiveAllTutor(int pageno, int pagesize) {
	    Pageable pageable = PageRequest.of(pageno, pagesize);
        Page<Tutor> tutorPage = tutorRepository.findAll(pageable);
        List<Tutor> tutors = tutorPage.getContent();
        List<ResposnseTutorDTO> tutorDTOs = new ArrayList<>();
        for (Tutor tutor : tutors) {
            ResposnseTutorDTO responseTutorDTO = new ResposnseTutorDTO();
            responseTutorDTO.setTutorId(tutor.getId());
            tutorDTOs.add(responseTutorDTO);
        }
        return tutorDTOs;
	}

}