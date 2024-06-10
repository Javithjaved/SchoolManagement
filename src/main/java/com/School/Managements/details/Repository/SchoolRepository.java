package com.School.Managements.details.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.School.Managements.details.Entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("SELECT s FROM School s WHERE (:name IS NULL OR s.schoolName LIKE %:name%)")
    Page<School> searchSchool(@Param("name") String schoolName, Pageable pageable);
}
