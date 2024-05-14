package com.college.managements.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.managements.entity.College;
@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

}
