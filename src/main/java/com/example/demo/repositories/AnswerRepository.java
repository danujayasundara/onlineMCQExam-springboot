package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Answer;
import com.example.demo.model.Exam;
import com.example.demo.model.Question;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{

	//Set<Answer> findByQuestion(Question question);
	//List<Answer> findByQuestionId(Question question);
	@Query(value = "SELECT * FROM answer WHERE question_id = :questionId", nativeQuery = true)
    List<Answer> findAnswersByQuestionIdSql(@Param("questionId") Long questionId);
	
	@Query(value = "SELECT * FROM Answer WHERE correct_answer = 1 AND question_id = :questionId", 
     nativeQuery = true)
	Answer findCorrectAnswer(@Param("questionId") Long question);

	Optional<Answer> findByAnswerId(Long ansId);

	List<Answer> findByQuestion(Question questionId);

	//Answer findByQuestion(Question questionId);

	//Answer correctAnswer(Question questionId);
	

}
