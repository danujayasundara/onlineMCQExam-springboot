package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Answer;
import com.example.demo.model.Exam;
import com.example.demo.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

	//Set<Question> findByExam(Exam exam);
	List<Question> findByExam(Exam exam_id);

	@Query(value = "SELECT * FROM question  WHERE question_id = ?", 
			nativeQuery = true)
	Optional<Question> findByQuestionId(Long quesId);

	//List<Answer> findByQuestionId(Long questionId);
	

	
}
