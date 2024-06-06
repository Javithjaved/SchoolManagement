package com.School.Managements.details.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.School.Managements.details.Entity.Question;
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query(value="SELECT * FROM question WHERE question_text LIKE %:questiontext%",nativeQuery = true)
	List<Question> findByQuestion(String questiontext);

}
