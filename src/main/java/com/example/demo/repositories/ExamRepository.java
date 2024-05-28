package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Exam;

@Repository
@EnableJpaRepositories
public interface ExamRepository extends JpaRepository<Exam, Long>{
	List<Exam> findAll();
	
	/*@Query(value = "SELECT e.exam_name, q.question_content FROM exam e JOIN question q ON q.exam_id = e.exam_id WHERE q.exam_id = ?", 
			nativeQuery = true)
	Exam getSavedExam(Long examId);*/

	//Optional<Exam> findByexa(Exam examId);

	String getExamNameByExamId(Long examId);
	
	@Query(value = "SELECT * FROM exam  WHERE exam_id = ?", 
			nativeQuery = true)
	Exam findByExamId(Long examId);

	List<Exam> findByeStatus(boolean b);
	
	@Query(value = "SELECT e.duration FROM Exam e WHERE e.exam_id = :examId",
			nativeQuery = true)
    Integer findDurationByExamId(@Param("examId") Long examId);
	

	@Query(value = "select question_id from question q JOIN exam e on q.exam_id = e.exam_id WHERE e.exam_id = :examId",
			nativeQuery = true)
	List<Long> findQuestionIdByExamId(Long examId);
	
	@Query("SELECT e FROM Exam e WHERE e.endExamStatus = true")
	List<Exam> findByisEndExamStatus();

	//List<Exam> findByExamNameContainingIgnoreCase(String exam_name);
	

}
