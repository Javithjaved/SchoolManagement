package com.School.Managements.details.Repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.School.Managements.details.Entity.School;

public interface SchoolRepository extends JpaRepository<School, Long> {

    @Query("SELECT s FROM School s WHERE s.schoolName LIKE %:schoolName% OR s.id = :schoolId")
    List<School> findBySchoolName(@Param("schoolName") String schoolName, @Param("schoolId") Long schoolId);
}


