package com.School.Managements.details.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.School.Managements.details.Entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s FROM Student s " +
            "WHERE (:studentName IS NULL OR :studentName = '' OR s.studentName LIKE %:studentName%) " +
            "AND (:schoolName IS NULL OR :schoolName = '' OR s.school.schoolName LIKE %:schoolName%) " +
            "AND (:location IS NULL OR :location = '' OR s.school.location LIKE %:location%)")
    List<Student> findStudentsBySearchParameters(@Param("studentName") String studentName, @Param("schoolName") String schoolName, @Param("location") String location);
}
