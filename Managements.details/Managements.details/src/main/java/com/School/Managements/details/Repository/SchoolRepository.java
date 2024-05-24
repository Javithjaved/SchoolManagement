package com.School.Managements.details.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.School.Managements.details.Entity.School;


public interface SchoolRepository extends JpaRepository<School, Long> {

}
