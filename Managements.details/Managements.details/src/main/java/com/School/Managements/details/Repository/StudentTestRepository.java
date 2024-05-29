package com.School.Managements.details.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.School.Managements.details.Entity.StudentTest;

@Repository
public interface StudentTestRepository extends JpaRepository<StudentTest, Long> {

	List<StudentTest> findByStudentId(Long studentId);

}
