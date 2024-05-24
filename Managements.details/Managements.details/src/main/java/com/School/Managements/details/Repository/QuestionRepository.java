package com.School.Managements.details.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.School.Managements.details.Entity.Question;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
