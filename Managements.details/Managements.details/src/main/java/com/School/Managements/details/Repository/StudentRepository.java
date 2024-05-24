package com.School.Managements.details.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.School.Managements.details.Entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
