package com.School.Managements.details.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.School.Managements.details.Entity.Tutor;
@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
